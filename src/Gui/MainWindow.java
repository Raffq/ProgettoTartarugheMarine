package Gui;

import javax.swing.*;

public class MainWindow extends JFrame {

    private AccediGUI login;

    public MainWindow() {
        super("Tartarughe");

        login = new AccediGUI();
    }
}