package Gui.TecnicoLaboratorioGUI;

import javax.swing.*;
import java.awt.*;

public class Tecnico_LaboratorioTemp extends JFrame {
    private JButton aggiungiVasca;
    public Tecnico_LaboratorioTemp() {
        super("Tecnico laboratorio");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        aggiungiVasca = new JButton();

        add(aggiungiVasca);

        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
