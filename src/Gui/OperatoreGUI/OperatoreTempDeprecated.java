package Gui.OperatoreGUI;

import javax.swing.*;
import java.awt.*;
@Deprecated
public class OperatoreTempDeprecated extends JFrame {
    JPanel panelFinto;
    public OperatoreTempDeprecated() {
        super("Operatore");
        panelFinto=new JPanel();
        OperatoreTemp bottoniOperatore = new OperatoreTemp();

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


