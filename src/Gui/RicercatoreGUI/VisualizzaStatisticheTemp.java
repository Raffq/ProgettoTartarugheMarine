package Gui.RicercatoreGUI;

import javax.swing.*;
import java.awt.*;

public class VisualizzaStatisticheTemp extends JFrame {
    public VisualizzaStatisticheTemp() {
        super("Visualizzazione statistiche");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        //TODO: grafici

        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
