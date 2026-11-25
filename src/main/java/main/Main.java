package main;

import java.sql.SQLException;
import dao.CategoryDAO;
import dao.ProductDAO;
import model.Category;
import model.Product;

public class Main {
    public static void main(String[] args) throws SQLException {
        ProductDAO dao = new ProductDAO();
        for (Product product : dao.findAll()) {
            printProduct(product);
        }
        printProduct(dao.findById(1));
        printProduct(dao.findById(100));
        System.out.println("result:" + dao.delete(8));
        try {
            for (Category category : new CategoryDAO().findAll()) {
                System.out.println(category.getId() + ":" + category.getName());
            }
        } catch (SQLException e) {
            System.err.println("Failed to get the category list.");
        }
        try {
            Product lamp = new Product(0, "Desk Lamp", 30000, 4, 1);
            System.out.println("result:" + dao.insert(lamp));
        } catch (SQLException e) {
            System.err.println("Failed to add the product.");
        }
    }

    private static void printProduct(Product product) {
        if (product == null) {
            System.out.println("There is no product with the specified ID.");
            return;
        }
        System.out.println("id:" + product.getId());
        System.out.println("name:" + product.getName());
        System.out.println("price:" + product.getPrice());
        System.out.println("stock:" + product.getStock());
        System.out.println("categoryId:" + product.getCategoryId());
        System.out.println("categoryName:" + product.getCategoryName());
        System.out.println("**********");
    }
}
