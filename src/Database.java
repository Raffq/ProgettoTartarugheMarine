import java.sql.*;
public class Database {
    private static String url="jdbc:postgresql://localhost:5432/CENTRO DI RICOVERO PER TARTARUGHE MARINE";
    private static String user="postgres";
    private static String password="";

    private Database() {}

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(url, user, password);

        return connection;
    }
}
