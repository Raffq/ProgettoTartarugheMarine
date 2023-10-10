package Gui.OperatoreGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

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

        Color colorLightGreen=new Color(7,209, 0);
        setBackground(colorLightGreen);

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
