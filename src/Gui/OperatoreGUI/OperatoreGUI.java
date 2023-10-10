package Gui.OperatoreGUI;

import javax.swing.*;
import java.awt.*;

public class OperatoreGUI extends JPanel {
    private AmmettiGUI ammettiPanel;
    private RiammettiGUI riammettiPanel;
    private RilasciaGUI rilasciaPanel;

    public OperatoreGUI() {
        ammettiPanel = new AmmettiGUI();
        add(ammettiPanel);
        ammettiPanel.setVisible(false);

        riammettiPanel = new RiammettiGUI();
        add(riammettiPanel);
        riammettiPanel.setVisible(false);

        rilasciaPanel = new RilasciaGUI();
        add(rilasciaPanel);
        rilasciaPanel.setVisible(false);

    }

    public void showAmmetti() {
        riammettiPanel.setVisible(false);
        rilasciaPanel.setVisible(false);

        ammettiPanel.setVisible(true);
    }

    public AmmettiGUI getAmmettiPanel() {
        return ammettiPanel;
    }

    public void showRiAmmetti() {
        ammettiPanel.setVisible(false);
        rilasciaPanel.setVisible(false);

        riammettiPanel.setVisible(true);
    }

    public RiammettiGUI getRiammettiPanel() {
        return riammettiPanel;
    }

    public void showRilascia() {
        ammettiPanel.setVisible(false);
        riammettiPanel.setVisible(false);

        rilasciaPanel.setVisible(true);
    }

    public RilasciaGUI getRilasciaPanel() {
        return rilasciaPanel;
    }
}