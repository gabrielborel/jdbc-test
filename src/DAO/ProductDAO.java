package DAO;

import model.Category;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private final Connection conn;
    public ProductDAO(Connection conn) {
        this.conn = conn;
    }

    public void save(Product product) throws SQLException {
        String query = "INSERT INTO product (name, description) VALUES (?, ?)";
        try(PreparedStatement stmt = this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.execute();

            try(ResultSet result = stmt.getGeneratedKeys()) {
                while(result.next()) {
                    product.setId(result.getInt(1));
                }
            }
        }
    }

    public List<Product> list() throws SQLException {
        List<Product> products = new ArrayList<Product>();
        String query = "SELECT * FROM product";

        try(PreparedStatement stmt = this.conn.prepareStatement(query)) {
            stmt.execute();

            try (ResultSet results = stmt.getResultSet()) {
                while(results.next()) {
                    Product product = new Product(results.getInt(1), results.getString(2), results.getString(3));
                    products.add(product);
                }
            }
        }

        return products;
    }

    public List<Product> find(Category c) throws SQLException {
        List<Product> products = new ArrayList<Product>();
        String query = "SELECT * FROM product WHERE category_id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, c.getId());
            stmt.execute();

            try (ResultSet results = stmt.getResultSet()) {
                while(results.next()) {
                    Product product = new Product(results.getInt(1), results.getString(2), results.getString(3));
                    products.add(product);
                }
            }
        }

        return products;

    }
}
