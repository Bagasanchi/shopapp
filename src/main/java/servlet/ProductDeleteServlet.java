package servlet;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import dao.*;
import model.*;
@WebServlet("/productDelete")
public class ProductDeleteServlet extends PageServlet {
    @Override protected void doPost(HttpServletRequest r,HttpServletResponse s) throws ServletException,IOException {
        try {
            new ProductDAO().delete(number(r,"id"));s.sendRedirect("products");
        } catch(SQLException e){throw new ServletException(e);}
    }
}
