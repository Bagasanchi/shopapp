package servlet;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import dao.*;
@WebServlet("/products")
public class ProductListServlet extends PageServlet {
    @Override protected void doGet(HttpServletRequest r,HttpServletResponse s) throws ServletException,IOException {
        try {
            r.setAttribute("products",new ProductDAO().findAll());
            show(r,s,"productList");
        } catch(SQLException e){throw new ServletException(e);}
    }
}
