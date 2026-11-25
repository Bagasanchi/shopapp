package dao;

import java.sql.*;
import model.*;

public class UserDAO extends Jdbc {
    public User findByNameAndPassword(String name,String password) throws SQLException {
        return query("SELECT id,name,role FROM users WHERE name=? AND BINARY password=BINARY ?",r->new User(r.getInt(1),r.getString(2),null,r.getString(3)),name,password).stream().findFirst().orElse(null);
    }
}
