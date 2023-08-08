package Gui.OperatoreGUI;

import javax.swing.*;
import java.awt.*;
@Deprecated
public class OperatoreTemp extends JFrame {
    JPanel panelFinto;
    public OperatoreTemp() {
        super("Operatore");
        panelFinto=new JPanel();
        BottoniOperatore bottoniOperatore = new BottoniOperatore();

        BorderLayout borderLayout=new BorderLayout();

        setLayout(borderLayout);
        add(panelFinto, borderLayout.PAGE_START);
        add(bottoniOperatore, borderLayout.CENTER);

        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}


