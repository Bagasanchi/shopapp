package dao;

import java.sql.*;
import java.util.*;
import model.*;
import util.DBManager;

abstract class Jdbc {
    interface Mapper<T> { T read(ResultSet row) throws SQLException; }
    protected static PreparedStatement prepare(Connection db,String sql,Object... args) throws SQLException {
        PreparedStatement st=db.prepareStatement(sql);
        for(int i=0;i<args.length;i++) st.setObject(i+1,args[i]);
        return st;
    }
    protected static <T> List<T> query(String sql,Mapper<T> mapper,Object... args) throws SQLException {
        try(Connection db=DBManager.getConnection(); PreparedStatement st=prepare(db,sql,args); ResultSet rs=st.executeQuery()) {
            List<T> rows=new ArrayList<>();
            while(rs.next()) rows.add(mapper.read(rs));
            return rows;
        }
    }
    protected static int update(String sql,Object... args) throws SQLException {
        try(Connection db=DBManager.getConnection(); PreparedStatement st=prepare(db,sql,args)){return st.executeUpdate();}
    }
}
