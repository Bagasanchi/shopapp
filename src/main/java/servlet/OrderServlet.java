package servlet;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import dao.*;
import model.*;
@WebServlet("/order")
public class OrderServlet extends PageServlet {
    @Override protected void doGet(HttpServletRequest r,HttpServletResponse s) throws ServletException,IOException {
        try {
            Product product=new ProductDAO().findById(number(r,"id"));
            if(product==null){s.sendRedirect("shop");return;}
            r.setAttribute("p",product);
            show(r,s,"order");
        } catch(SQLException e){throw new ServletException(e);}
    }

    @Override protected void doPost(HttpServletRequest r,HttpServletResponse s) throws ServletException,IOException {
        try {
            User user=new UserDAO().findByNameAndPassword(value(r,"name"),value(r,"password"));
            Product product=new ProductDAO().findById(number(r,"id"));
            if(product==null){s.sendRedirect("shop");return;}
            int quantity=number(r,"quantity");
            Delivery delivery=switch(value(r,"deliveryName")){case "Express" -> new ExpressDelivery();case "Standard" -> new StandardDelivery();default -> null;};
            List<String> errors=util.Validator.validateOrder(value(r,"quantity"));
            if(user==null || !"customer".equals(user.getRole()))errors.add(0,"The name or password is wrong.");
            if(delivery==null)errors.add("Please choose a delivery method.");
            if(!errors.isEmpty())r.setAttribute("error",String.join(" ",errors));
            else try{
                OrderDAO orders=new OrderDAO();
                Order order=new Order(0,product.getId(),product.getName(),product.getPrice(),product.getCategoryId(),user.getId(),quantity,delivery.getName(),delivery.calcFee((long)product.getPrice()*quantity),null);
                orders.insert(order);r.setAttribute("orders",orders.findByUserId(user.getId()));show(r,s,"orderDone");return;
            }catch(IllegalArgumentException e){r.setAttribute("error",e.getMessage());}
            doGet(r,s);
        } catch(SQLException e){throw new ServletException(e);}
    }
}
