package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.Color;

import Gui.AccediTemp;

public class MainWindow extends JFrame {

    private AccediTemp login;

    public MainWindow() {
        super("Tartarughe");

        login = new AccediTemp();
    }
}