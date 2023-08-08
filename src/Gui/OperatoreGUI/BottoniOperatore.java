package Gui.OperatoreGUI;

import javax.swing.*;
import java.awt.*;
public class BottoniOperatore extends JPanel {
    private JButton ammetti;
    private JButton riammetti;
    private JButton rilascia;

    public BottoniOperatore() {
        ammetti=new JButton("Ammetti");
        riammetti=new JButton("Riammetti");
        rilascia=new JButton("Rilascia");

        FlowLayout flowLayout=new FlowLayout(FlowLayout.CENTER, 20, 0);
        setLayout(flowLayout);

        add(ammetti);
        add(riammetti);
        add(rilascia);
    }

}
