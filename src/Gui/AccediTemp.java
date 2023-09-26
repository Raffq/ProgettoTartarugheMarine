package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.Color;

import ClassiPrincipali.*;
import Controller.Controller;
import DAO.Medico_Veterinario.Medico_VeterinarioDAO;
import DAO.Medico_Veterinario.Medico_VeterinarioDAOImpl;
import DAO.Operatore.OperatoreDAO;
import DAO.Operatore.OperatoreDAOImpl;
import DAO.Tecnico_Laboratorio.Tecnico_LaboratorioDAO;
import DAO.Tecnico_Laboratorio.Tecnico_LaboratorioDAOImpl;
import Gui.OperatoreGUI.OperatoreTemp;

public class AccediTemp extends JFrame {
    private JTextField matricola;
    private JButton accedi;
    private JLabel labelAccedi;
    private Personale ps;

    public AccediTemp() {
        super("Accedi");

        setLayout(new BorderLayout());
        setSize(200, 120);
        setResizable(false);

        matricola = new JTextField();
        accedi = new JButton("Accedi");
        labelAccedi = new JLabel();

        labelAccedi.setText("Inserisci matricola");

        matricola.setBackground(Color.lightGray);

        add(labelAccedi, BorderLayout.PAGE_START);
        add(matricola, BorderLayout.CENTER);
        add(accedi, BorderLayout.PAGE_END);



        Controller controller = new Controller();

        accedi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matricolatemp = matricola.getText();
                try {
                    ps = controller.controllaMatricola(matricolatemp);
                    if(ps != null) {
                        controller.accedi(ps);
                        dispose();
                    }
                    else {
                        labelAccedi.setForeground(Color.RED);
                        labelAccedi.setText("Matricola errata!");

                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}