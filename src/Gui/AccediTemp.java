package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import ClassiPrincipali.*;
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
    Personale ps;
    public AccediTemp()  {
        super("Accedi");

        setLayout(new BorderLayout());

        matricola=new JTextField();
        accedi=new JButton("Accedi");

        add(accedi, BorderLayout.PAGE_START);
        add(matricola, BorderLayout.CENTER);

        accedi.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                ps=null;
                String matricolatemp = matricola.getText();
                try {
                    ps=controllaMatricola(matricolatemp);
                    accedi(ps);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                dispose(); //prova
            }
        });

        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    Personale controllaMatricola(String MatricolaTemp) throws SQLException {
        if (MatricolaTemp.substring(0, 2).equals("OP")) {
            OperatoreDAO operatoreDAO = new OperatoreDAOImpl();
            Personale operatore = operatoreDAO.get(MatricolaTemp);

            return operatore;
        }
        else if (MatricolaTemp.substring(0, 2).equals("TL")) {
            Tecnico_LaboratorioDAO tecnico_laboratorioDAO = new Tecnico_LaboratorioDAOImpl();
            Personale tecnico_laboratorio = tecnico_laboratorioDAO.get(MatricolaTemp);


            return tecnico_laboratorio;
        }
        else if (MatricolaTemp.substring(0, 2).equals("MV")) {
            Medico_VeterinarioDAO medico_veterinarioDAO = new Medico_VeterinarioDAOImpl();
            Personale medico_veterinario = medico_veterinarioDAO.get(MatricolaTemp);

            return medico_veterinario;
        }
        else {
            return null;
        }
    }

    void accedi(Personale personale) {
        if (personale instanceof Operatore) {
            OperatoreTemp operatoreTemp1=new OperatoreTemp();
            operatoreTemp1.show();
            System.out.println("OpenInterfaccia");
        }
        else if (personale instanceof Medico_Veterinario) {
            System.out.println("OpenInterfaccia");
        }
        else if (personale instanceof Tecnico_Laboratorio) {
            System.out.println("OpenInterfaccia");
        }
    }
}
