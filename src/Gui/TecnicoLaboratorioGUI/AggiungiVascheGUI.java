package Gui.TecnicoLaboratorioGUI;

import ClassiPrincipali.Personale;

import javax.swing.*;
import java.awt.*;

public class AggiungiVascheGUI extends JPanel {
    private JButton aggiungiVasca;
    private JButton conferma;
    private JComboBox<Integer> NumeroVasche;

    private Personale personale;
    Integer[] MaxVasche = new Integer[20];

    public AggiungiVascheGUI() {
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
        setVisible(true);
    }

    public void SetPersonale(Personale personale) {
        this.personale = personale;
    }

}