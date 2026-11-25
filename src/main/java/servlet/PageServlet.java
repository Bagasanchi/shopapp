package servlet;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import dao.*;
import model.*;
abstract class PageServlet extends HttpServlet {
    private static final Set<String> ADMIN=Set.of("/adminMenu","/products","/productDetail","/productDelete","/productAdd","/orders","/sales");
    protected String value(HttpServletRequest r,String field){return Objects.toString(r.getParameter(field),"");}
    protected int number(HttpServletRequest r,String field){
        try{return Integer.parseInt(value(r,field));}catch(NumberFormatException e){return -1;}
    }
    protected void show(HttpServletRequest r,HttpServletResponse s,String page) throws ServletException,IOException {
        r.getRequestDispatcher("/WEB-INF/"+page+".jsp").forward(r,s);
    }
    @Override protected void service(HttpServletRequest r,HttpServletResponse s) throws IOException,ServletException {
        r.setCharacterEncoding("UTF-8");
        if(ADMIN.contains(r.getServletPath()) && (r.getSession(false)==null || r.getSession(false).getAttribute("admin")==null)){s.sendRedirect("login");return;}
        super.service(r,s);
    }
}
