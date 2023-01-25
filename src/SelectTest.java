import java.sql.*;

public class SelectTest {
   public static void main(String[] args) throws SQLException {
      ConnectionFactory connFactory = new ConnectionFactory();
      Connection conn = connFactory.getConnection();

      String query = "SELECT id, name, description FROM product";
      PreparedStatement stmt = conn.prepareStatement(query);
      stmt.execute();
      ResultSet results = stmt.getResultSet();
      while (results.next()) {
         Integer id = results.getInt("id");
         String name = results.getString("name");
         String description = results.getString("description");

         System.out.println(id);
         System.out.println(name);
         System.out.println(description);
      }

      conn.close();
   }
}
