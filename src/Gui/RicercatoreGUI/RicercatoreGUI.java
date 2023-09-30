package Gui.RicercatoreGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.Controller;

public class RicercatoreGUI extends JFrame {
    private JButton visualizzaStatistiche;
    public RicercatoreGUI() {
        super("Ricercatore");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        visualizzaStatistiche = new JButton("Visualizza statistiche");

        Controller controller = new Controller();

        visualizzaStatistiche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                // Chiamare i metodi del controller quando il pulsante viene premuto
                controller.goToStatistiche();
            }
        });

        add(visualizzaStatistiche);

        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
