package dao;

import java.sql.*;
import java.util.*;
import model.*;
import util.DBManager;

public class CategoryDAO extends Jdbc {
    public List<Category> findAll() throws SQLException {
        return query("SELECT id,name FROM category ORDER BY id",r->new Category(r.getInt(1),r.getString(2)));
    }
}
