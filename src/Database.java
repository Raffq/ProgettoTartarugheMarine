import java.sql.*;
//TODO: Aggiungere Url, user, password
public class Database {
    private static String url="";
    private static String user="";
    private static String password="";

    private Database() {

    }

    public static Connection getConnection() throws SQLException {
        Connection connection= null;
        connection = DriverManager.getConnection(url, user, password);

        return connection;
    }
}
