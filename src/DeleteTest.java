import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connFactory = new ConnectionFactory();
        Connection conn = connFactory.getConnection();

        String query = "DELETE FROM product WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, 3);
        stmt.execute();

        Integer affectedRows = stmt.getUpdateCount();

        System.out.println(affectedRows);

        conn.close();
    }
}
