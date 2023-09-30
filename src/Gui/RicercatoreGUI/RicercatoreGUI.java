package Gui.RicercatoreGUI;

import javax.swing.*;

public class RicercatoreGUI extends JPanel {

    private VisualizzaStatisticheGUI visualizzaStatistichePanel;

    public RicercatoreGUI() {
        visualizzaStatistichePanel = new VisualizzaStatisticheGUI();
        add(visualizzaStatistichePanel);
        visualizzaStatistichePanel.setVisible(false);
    }

    public void showvisualizzaStatistiche()
    {
        visualizzaStatistichePanel.setVisible(true);
    }

    public VisualizzaStatisticheGUI getVisualizzaStatistichePanel() {
        return visualizzaStatistichePanel;
    }
}