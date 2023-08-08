package Gui.RicercatoreGUI;

import javax.swing.*;
import java.awt.*;

public class RicercatoreTemp extends JFrame {
    private JButton visualizzaStatistiche;
    public RicercatoreTemp() {
        super("Ricercatore");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        visualizzaStatistiche = new JButton();

        add(visualizzaStatistiche);

        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
