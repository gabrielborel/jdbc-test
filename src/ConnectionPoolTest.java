import java.sql.SQLException;

public class ConnectionPoolTest {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connFactory = new ConnectionFactory();

        for (int i = 0; i < 20; i++) {
            connFactory.getConnection();
            System.out.println("Connection number: " + i);
        }
    }
}
