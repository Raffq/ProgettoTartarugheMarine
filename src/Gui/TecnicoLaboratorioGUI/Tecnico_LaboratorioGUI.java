package Gui.TecnicoLaboratorioGUI;

import javax.swing.*;
import java.awt.*;

public class Tecnico_LaboratorioGUI extends JFrame {
    private JButton aggiungiVasca;
    private JButton conferma;
    private JComboBox<Integer> NumeroVasche;
    Integer[] MaxVasche = new Integer[20];

    public Tecnico_LaboratorioGUI() {
        super("Tecnico laboratorio");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        for(int i=0;i<20;i++)
        {
            MaxVasche[i]= i+1;
        }

        aggiungiVasca = new JButton("Aggiungi Vasca");
        conferma = new JButton("conferma");
        NumeroVasche = new JComboBox<>(MaxVasche);

        add(aggiungiVasca);
        add(conferma);
        add(NumeroVasche);

        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
