import DAO.CategoryDAO;
import DAO.ProductDAO;
import model.Category;
import model.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SelectCategoriesTest {
   public static void main(String[] args) throws SQLException {
      try (Connection conn = new ConnectionFactory().getConnection()) {
         CategoryDAO categoryDAO = new CategoryDAO(conn);
         List<Category> categories = categoryDAO.listWithProducts();
         categories.forEach((c) -> {
            for (Product product : c.getProducts()) {
               System.out.println(c.getName() + "-" + product.getName());
            }
         });
      }
   }
}
