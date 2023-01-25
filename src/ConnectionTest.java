import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTest {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connFactory = new ConnectionFactory();
        Connection conn = connFactory.getConnection();

        conn.close();
    }
}
