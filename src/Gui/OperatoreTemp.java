package Gui;

import ClassiPrincipali.Personale;
import DAO.Medico_Veterinario.Medico_VeterinarioDAO;
import DAO.Medico_Veterinario.Medico_VeterinarioDAOImpl;
import DAO.Operatore.OperatoreDAO;
import DAO.Operatore.OperatoreDAOImpl;
import DAO.Tecnico_Laboratorio.Tecnico_LaboratorioDAO;
import DAO.Tecnico_Laboratorio.Tecnico_LaboratorioDAOImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class OperatoreTemp extends JFrame {
    JPanel panelFinto;
    public OperatoreTemp() {
        super("Operatore");
        panelFinto=new JPanel();
        BottoniOperatore bottoniOperatore = new BottoniOperatore();

        BorderLayout borderLayout=new BorderLayout();

        setLayout(borderLayout);
        add(panelFinto, borderLayout.PAGE_START);
        add(bottoniOperatore, borderLayout.CENTER);

        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}


