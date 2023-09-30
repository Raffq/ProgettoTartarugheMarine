package Gui.OperatoreGUI;

import javax.swing.*;

public class OperatoreButtonsGUI extends JPanel {

    private JButton ammettiButton;
    private JButton riammettiButton;
    private JButton rilasciaButton;

    public OperatoreButtonsGUI() {
        ammettiButton = new JButton("Ammetti");
        riammettiButton = new JButton("Riammetti");
        rilasciaButton = new JButton("Rilascia");

        add(ammettiButton);
        add(riammettiButton);
        add(rilasciaButton);
    }

    public JButton getAmmettiButton()
    {
        return ammettiButton;
    }

    public JButton getRiammettiButton()
    {
        return riammettiButton;
    }

    public JButton getRilasciaButton()
    {
        return rilasciaButton;
    }
}
