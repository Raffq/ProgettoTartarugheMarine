/*package Gui.OperatoreGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import ClassiPrincipali.Personale;
import Controller.Controller;

public class OperatoreGUI extends JFrame {
    private JButton ammetti;
    private JButton riammetti;
    private JButton rilascia;

    public OperatoreGUI(Personale personale) {
        FlowLayout flowLayout=new FlowLayout(FlowLayout.CENTER, 20, 0);
        setLayout(flowLayout);

        ammetti=new JButton("Ammetti");
        riammetti=new JButton("Riammetti");
        rilascia=new JButton("Rilascia");

        Controller controller = new Controller();

        ammetti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                // Chiamare i metodi del controller quando il pulsante viene premuto
                    controller.goToAmmetti(personale);
            }
        });

        riammetti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                // Chiamare i metodi del controller quando il pulsante viene premuto
                try {
                    controller.goToRiammetti(personale);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        rilascia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                // Chiamare i metodi del controller quando il pulsante viene premuto
                try {
                    controller.goToRilascia(personale);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        add(ammetti);
        add(riammetti);
        add(rilascia);

        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
*/