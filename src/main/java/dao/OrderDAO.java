package dao;

import java.sql.*;
import java.util.*;
import model.*;
import util.DBManager;

public class OrderDAO extends Jdbc {
    private static final String SELECT="SELECT o.*, u.name customer,c.name category FROM orders o JOIN users u ON u.id=o.user_id JOIN category c ON c.id=o.category_id";
    private static Order map(ResultSet r) throws SQLException {
        Order o=new Order(r.getInt("id"),r.getInt("product_id"),r.getString("product_name"),r.getInt("price"),r.getInt("category_id"),r.getInt("user_id"),r.getInt("quantity"),r.getString("delivery_name"),r.getInt("delivery_fee"),r.getString("ordered_at"));
        o.setUserName(r.getString("customer"));o.setCategoryName(r.getString("category"));return o;
    }
    public int insert(Order o) throws SQLException {
        try(Connection db=DBManager.getConnection()){
            db.setAutoCommit(false);
            try{
                if(ProductDAO.reduceStock(db,o.getProductId(),o.getQuantity())!=1)throw new IllegalArgumentException("Insufficient stock.");
                try(var st=prepare(db,"INSERT INTO orders(product_id,product_name,price,category_id,user_id,quantity,delivery_name,delivery_fee) VALUES(?,?,?,?,?,?,?,?)",o.getProductId(),o.getProductName(),o.getPrice(),o.getCategoryId(),o.getUserId(),o.getQuantity(),o.getDeliveryName(),o.getDeliveryFee())){
                    int count=st.executeUpdate();db.commit();return count;
                }
            }catch(SQLException|RuntimeException e){db.rollback();throw e;}
        }
    }
    public List<Order> findAll() throws SQLException {return query(SELECT+" ORDER BY o.ordered_at DESC,o.id DESC",OrderDAO::map);}
    public List<Order> findByUserId(int id) throws SQLException {return query(SELECT+" WHERE user_id=? ORDER BY o.ordered_at DESC,o.id DESC",OrderDAO::map,id);}
    public long sumAll() throws SQLException {return query("SELECT COALESCE(SUM(CAST(price AS SIGNED)*quantity),0) FROM orders",r->r.getLong(1)).get(0);}
    private List<Sales> sales(String group) throws SQLException {
        return query("SELECT "+group+",SUM(quantity),SUM(CAST(price AS SIGNED)*quantity) amount FROM orders o JOIN category c ON c.id=o.category_id GROUP BY "+group+" ORDER BY amount DESC,1",r->new Sales(r.getString(1),r.getLong(2),r.getLong(3)));
    }
    public List<Sales> sumByProduct() throws SQLException {return sales("o.product_name");}
    public List<Sales> sumByCategory() throws SQLException {return sales("c.name");}
}
