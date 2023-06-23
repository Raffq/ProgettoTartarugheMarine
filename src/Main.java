import java.sql.*;
public class Main {
    public static void main(String[] args) throws SQLException {
        Connection con = Database.getConnection();

        if (con!=null) {
            System.out.println("Successo!");
        }
        else {
            System.out.println("No!");
        }
    }
}