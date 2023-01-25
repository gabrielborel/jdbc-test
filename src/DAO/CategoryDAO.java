package DAO;

import model.Category;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private final Connection conn;

    public CategoryDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Category> list() throws SQLException {
        List<Category> categories = new ArrayList<>();
        String query = "SELECT * FROM category";

        try(PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.execute();

            try(ResultSet results = stmt.getResultSet()) {
                while(results.next()) {
                    Category category = new Category(results.getInt(1), results.getString(2));
                    categories.add(category);
                }
            }
        }

        return categories;
    }

    public List<Category> listWithProducts() throws SQLException {
        Category last = null;
        List<Category> categories = new ArrayList<>();
        String query = "SELECT c.id, c.name, p.id, p.name, p.description FROM category c INNER JOIN" + " product p ON c.id = p.category_id";

        try(PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.execute();

            try(ResultSet results = stmt.getResultSet()) {
                while(results.next()) {
                    if (last == null || !last.getName().equals(results.getString(2))) {
                        Category category = new Category(results.getInt(1), results.getString(2));
                        last = category;
                        categories.add(category);
                    }
                    Product product = new Product(results.getInt(3), results.getString(4), results.getString(5));
                    last.addProduct(product);
                }
            }
        }

        return categories;
    }
}
