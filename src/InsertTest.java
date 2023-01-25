import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connFactory = new ConnectionFactory();
        Connection conn = connFactory.getConnection();

        Statement stmt = conn.createStatement();
        stmt.execute("INSERT INTO product (name, description) VALUES ('keyboard', 'keychron k2')", Statement.RETURN_GENERATED_KEYS);

        ResultSet result = stmt.getGeneratedKeys();
        while(result.next()) {
            Integer id = result.getInt(1);
            System.out.println(id);
        }

        conn.close();
    }
}
