package servlet;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import dao.*;
@WebServlet("/sales")
public class SalesServlet extends PageServlet {
    @Override protected void doGet(HttpServletRequest r,HttpServletResponse s) throws ServletException,IOException {
        try {
            OrderDAO dao=new OrderDAO();
            r.setAttribute("byProduct",dao.sumByProduct());
            r.setAttribute("byCategory",dao.sumByCategory());
            r.setAttribute("total",dao.sumAll());
            show(r,s,"sales");
        } catch(SQLException e){throw new ServletException(e);}
    }
}
