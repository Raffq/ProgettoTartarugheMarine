import Controller.Controller;
import Gui.MainWindow.MainWindow;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        MainWindow window = new MainWindow(new Controller());
    }
}
