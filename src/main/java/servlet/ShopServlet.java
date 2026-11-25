package servlet;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import dao.*;
import model.*;
@WebServlet("/shop")
public class ShopServlet extends PageServlet {
    @Override protected void doGet(HttpServletRequest r,HttpServletResponse s) throws ServletException,IOException {
        try {
            r.setAttribute("products", new ProductDAO().search(value(r,"keyword"), Math.max(0,number(r,"categoryId")),value(r,"sort")));
            r.setAttribute("categories", new CategoryDAO().findAll());
            show(r,s,"shop");
        } catch(SQLException e){throw new ServletException(e);}
    }
}
