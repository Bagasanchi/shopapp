package servlet;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import dao.*;
@WebServlet("/orders")
public class OrderListServlet extends PageServlet {
    @Override protected void doGet(HttpServletRequest r,HttpServletResponse s) throws ServletException,IOException {
        try {
            r.setAttribute("orders",new OrderDAO().findAll());
            show(r,s,"orders");
        } catch(SQLException e){throw new ServletException(e);}
    }
}
