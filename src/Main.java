import Controller.Controller;
import Gui.MainWindow.MainWindow;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, MalformedURLException, IOException {
        MainWindow window = new MainWindow(new Controller());
    }
}
