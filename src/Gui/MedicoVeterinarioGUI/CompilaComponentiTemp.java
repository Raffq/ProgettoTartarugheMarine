package Gui.MedicoVeterinarioGUI;

import javax.swing.*;
import java.awt.*;

public class CompilaComponentiTemp extends JFrame {
    private JLabel componente;
    private JRadioButton condizione1, condizione2, condizione3, condizione4, condizione5;
    private JTextField dataCompilazione;
    private JButton conferma;
    public CompilaComponentiTemp() {
        super("Compila componenti tartaruga");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        componente = new JLabel("Testa");

        condizione1 = new JRadioButton("compromesso");
        condizione2 = new JRadioButton("ferite profonde");
        condizione3 = new JRadioButton("ferite superficiali");
        condizione4 = new JRadioButton("buono");
        condizione5 = new JRadioButton("perfetto");

        ButtonGroup sceltaCondizione = new ButtonGroup();
        sceltaCondizione.add(condizione1);
        sceltaCondizione.add(condizione2);
        sceltaCondizione.add(condizione3);
        sceltaCondizione.add(condizione4);
        sceltaCondizione.add(condizione5);

        dataCompilazione = new JTextField("data");
        dataCompilazione.setPreferredSize( new Dimension( 200, 24 ) );

        conferma = new JButton("conferma");

        add(componente);
        add(condizione1);
        add(condizione2);
        add(condizione3);
        add(condizione4);
        add(condizione5);
        add(dataCompilazione);
        add(conferma);

        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
