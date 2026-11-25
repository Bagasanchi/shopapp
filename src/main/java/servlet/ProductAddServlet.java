package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.CategoryDAO;
import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import util.Validator;

@WebServlet("/productAdd")
public class ProductAddServlet extends PageServlet {
    private void showForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("categoryList", new CategoryDAO().findAll());
            show(request, response, "productAdd");
        } catch (SQLException e) {
            throw new ServletException("Failed to get the category list.", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        showForm(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = value(request, "name").strip();
        String categoryId = value(request, "categoryId");
        String price = value(request, "price");
        String stock = value(request, "stock");
        List<String> errors = Validator.validateProduct(name, price, stock);

        try {
            if (new CategoryDAO().findAll().stream()
                    .noneMatch(category -> String.valueOf(category.getId()).equals(categoryId))) {
                errors.add("Select a valid category.");
            }
            if (!errors.isEmpty()) {
                request.setAttribute("errors", errors);
                showForm(request, response);
                return;
            }

            Product product = new Product(0, name, Integer.parseInt(price),
                    Integer.parseInt(stock), Integer.parseInt(categoryId));
            new ProductDAO().insert(product);
            response.sendRedirect("products");
        } catch (SQLException e) {
            throw new ServletException("Failed to add the product.", e);
        }
    }
}
