package servlet;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import dao.*;
import model.*;
@WebServlet("/login")
public class LoginServlet extends PageServlet {
    @Override protected void doGet(HttpServletRequest r,HttpServletResponse s) throws ServletException,IOException {
        show(r,s,"login");
    }

    @Override protected void doPost(HttpServletRequest r,HttpServletResponse s) throws ServletException,IOException {
        try {
            User user=new UserDAO().findByNameAndPassword(value(r,"name"),value(r,"password"));
            if(user!=null && "admin".equals(user.getRole())){
                r.getSession().setAttribute("admin",user.getId());r.changeSessionId();s.sendRedirect("adminMenu");return;
            }
            r.setAttribute("error","Invalid administrator name or password.");doGet(r,s);
        } catch(SQLException e){throw new ServletException(e);}
    }
}
