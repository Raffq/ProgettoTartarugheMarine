package Gui.RicercatoreGUI;

import javax.swing.*;

public class RicercatoreButtonsGUI extends JPanel {
    private JButton visualizzaStatistiche;
    public RicercatoreButtonsGUI()
    {
        visualizzaStatistiche = new JButton("Visualizza statistiche");
        add(visualizzaStatistiche);
    }
    public JButton getVisualizzaStatistiche() {
        return visualizzaStatistiche;
    }
}
