import DAO.ProductDAO;
import model.Product;

import java.sql.*;
import java.util.List;

public class InsertTestAndListWithProduct {
    public static void main(String[] args) throws SQLException {
        Product car = new Product("Bike", "A KTM Duke 390");

        try (Connection conn = new ConnectionFactory().getConnection()) {
            ProductDAO productDAO = new ProductDAO(conn);
            productDAO.save(car);

            List<Product> products = productDAO.list();
            products.forEach(System.out::println);
        }

        System.out.println(car);
    }
}
