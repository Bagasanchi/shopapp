package servlet;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import dao.*;
import model.*;
@WebServlet("/shopDetail")
public class ShopDetailServlet extends PageServlet {
    @Override protected void doGet(HttpServletRequest r,HttpServletResponse s) throws ServletException,IOException {
        try {
            Product product=new ProductDAO().findById(number(r,"id"));
            if(product==null){s.sendRedirect("shop");return;}
            r.setAttribute("p",product);
            show(r,s,"shopDetail");
        } catch(SQLException e){throw new ServletException(e);}
    }
}
