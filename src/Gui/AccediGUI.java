package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

import static java.awt.Color.black;

public class AccediGUI extends JPanel {

    private JButton buttonLogin;

    private JTextField loginMatricola;

    private JLabel accediLabel;

    public AccediGUI() {
        buttonLogin = new JButton("Accedi");;
        loginMatricola = new JTextField();
        accediLabel = new JLabel("Inserisci matricola");

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 120));
        setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, black));

        buttonLogin.setBackground(Color.gray);

        add(accediLabel, BorderLayout.PAGE_START);
        add(loginMatricola, BorderLayout.CENTER);
        add(buttonLogin, BorderLayout.PAGE_END);
    }

    public JButton getButtonLogin() {
        return buttonLogin;
    }

    public JTextField getLoginMatricola() {
        return loginMatricola;
    }

    public JLabel getAccediLabel() {
        return accediLabel;
    }
}

