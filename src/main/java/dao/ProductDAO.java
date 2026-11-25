package dao;

import java.sql.*;
import java.util.*;
import model.*;
import util.DBManager;

public class ProductDAO extends Jdbc {
    private static final String SELECT="SELECT p.*,c.name category FROM product p JOIN category c ON c.id=p.category_id";
    private static Product map(ResultSet r) throws SQLException {
        Product p=new Product(r.getInt("id"),r.getString("name"),r.getInt("price"),r.getInt("stock"),r.getInt("category_id"));
        p.setCategoryName(r.getString("category"));
        return p;
    }
    public List<Product> findAll() throws SQLException {return query(SELECT+" ORDER BY p.id",ProductDAO::map);}
    public Product findById(int id) throws SQLException {return query(SELECT+" WHERE p.id=?",ProductDAO::map,id).stream().findFirst().orElse(null);}
    public List<Product> findInStock() throws SQLException {return search("",0,"idAsc");}
    public List<Product> search(String keyword,int categoryId,String sort) throws SQLException {
        String order=switch(sort){case "idDesc" -> "p.id DESC";case "priceAsc" -> "price,p.id";case "priceDesc" -> "price DESC,p.id";default -> "p.id";};
        return query(SELECT+" WHERE stock>0 AND LOCATE(?,p.name)>0 AND (?=0 OR category_id=?) ORDER BY "+order,ProductDAO::map,keyword,categoryId,categoryId);
    }
    public int insert(Product p) throws SQLException {return update("INSERT INTO product(name,price,stock,category_id) VALUES(?,?,?,?)",p.getName(),p.getPrice(),p.getStock(),p.getCategoryId());}
    public int delete(int id) throws SQLException {return update("DELETE FROM product WHERE id=?",id);}
    static int reduceStock(Connection db,int id,int quantity) throws SQLException {
        try(var st=prepare(db,"UPDATE product SET stock=stock-? WHERE id=? AND stock>=?",quantity,id,quantity)){return st.executeUpdate();}
    }
    public int reduceStock(int id,int quantity) throws SQLException {
        try(var db=DBManager.getConnection()){return reduceStock(db,id,quantity);}
    }
}
