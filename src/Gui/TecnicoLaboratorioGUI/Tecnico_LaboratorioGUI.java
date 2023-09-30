package Gui.TecnicoLaboratorioGUI;

import Gui.RicercatoreGUI.VisualizzaStatisticheGUI;

import javax.swing.*;

public class Tecnico_LaboratorioGUI extends JPanel {
    private AggiungiVascheGUI aggiungiVaschePanel;

    public Tecnico_LaboratorioGUI() {
        aggiungiVaschePanel = new AggiungiVascheGUI();
        add(aggiungiVaschePanel);
        aggiungiVaschePanel.setVisible(false);
    }

    public void showAggiungiVasche()
    {
        aggiungiVaschePanel.setVisible(true);
    }

    public AggiungiVascheGUI getAggiungiVaschePanel() {
        return aggiungiVaschePanel;
    }
}
