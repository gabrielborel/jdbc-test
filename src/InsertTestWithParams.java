import java.sql.*;

public class InsertTestWithParams {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connFactory = new ConnectionFactory();
        try(Connection conn = connFactory.getConnection()) {
            conn.setAutoCommit(false);

            try (
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO product (name, description) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            ){
                addVariable("Webcam", "A nice 4k webcam", stmt);
                addVariable("TV", "A nice Television", stmt);

                conn.commit();
            } catch (Exception ex) {
                ex.printStackTrace();
                conn.rollback();
            }
        }
    }

    private static void addVariable(String name, String description, PreparedStatement stmt) throws SQLException {
        stmt.setString(1, name);
        stmt.setString(2, description);
        stmt.execute();

        try(ResultSet result = stmt.getGeneratedKeys()) {
            while(result.next()) {
                Integer id = result.getInt(1);
                System.out.println(id);
            }
        }
    }
}
