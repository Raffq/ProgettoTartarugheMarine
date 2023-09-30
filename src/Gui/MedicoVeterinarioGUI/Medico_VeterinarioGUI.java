package Gui.MedicoVeterinarioGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import ClassiPrincipali.Personale;
import Controller.Controller;

public class Medico_VeterinarioGUI extends JFrame {
    private JButton compilaComponente;
    private JButton compilaCartellaClinica;
    private JButton modificaComponente;
    private JButton modificaCartellaClinica;
    public Medico_VeterinarioGUI(Personale personale){
        super("Medico veterinario");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        compilaComponente = new JButton("Compila componenti");
        compilaCartellaClinica = new JButton("Compila cartella clinica");
        modificaComponente = new JButton("Modifica componenti");
        modificaCartellaClinica = new JButton("Modifica cartella clinica");

        Controller controller = new Controller();

        compilaCartellaClinica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                // Chiamare i metodi del controller quando il pulsante viene premuto
                try {
                    controller.goToCompilaCartellaClinica(personale);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        compilaComponente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                // Chiamare i metodi del controller quando il pulsante viene premuto
                try {
                    controller.goToCompilaComponenti(personale);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        modificaComponente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                // Chiamare i metodi del controller quando il pulsante viene premuto
                try {
                    controller.goToModificaComponenti(personale);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        modificaCartellaClinica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                // Chiamare i metodi del controller quando il pulsante viene premuto
                try {
                    controller.goToModificaCartellaClinica(personale);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        add(compilaComponente);
        add(compilaCartellaClinica);
        add(modificaComponente);
        add(modificaCartellaClinica);

        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
