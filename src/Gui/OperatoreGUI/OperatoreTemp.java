package Gui.OperatoreGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.Controller;

public class OperatoreTemp extends JFrame {
    private JButton ammetti;
    private JButton riammetti;
    private JButton rilascia;

    public OperatoreTemp() {
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
                controller.goToAmmetti();
            }
        });

        riammetti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                // Chiamare i metodi del controller quando il pulsante viene premuto
                controller.goToRiammetti();
            }
        });

        rilascia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                // Chiamare i metodi del controller quando il pulsante viene premuto
                controller.goToRilascia();
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
