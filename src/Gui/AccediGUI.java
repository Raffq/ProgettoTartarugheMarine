package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

import static java.awt.Color.black;

public class AccediGUI extends JPanel {

    private JButton buttonLogin;
    private JTextField loginMatricola;

    private JLabel accediLabel;

    public AccediGUI(JButton buttonLogin, JTextField loginMatricola, JLabel accediLabel) {
        this.buttonLogin = buttonLogin;
        this.loginMatricola = loginMatricola;
        this.accediLabel = accediLabel;

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 120));
        setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, black));

        buttonLogin.setBackground(Color.gray);

        add(accediLabel, BorderLayout.PAGE_START);
        add(loginMatricola, BorderLayout.CENTER);
        add(buttonLogin, BorderLayout.PAGE_END);
    }
}