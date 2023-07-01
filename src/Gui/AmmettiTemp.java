package Gui;

import javax.swing.*;
import java.awt.*;
import java.time.chrono.JapaneseDate;
import java.util.GregorianCalendar;

public class AmmettiTemp extends JFrame {
    private JTextField nomeTart;
    private JComboBox anno;
    private JComboBox mese;
    private JComboBox giorno;
    private JComboBox comboBox;
    public AmmettiTemp() {
        super("Ammetti");

        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        nomeTart=new JTextField(15);

        Integer[] annoint = new Integer[2023-1979+1];
        Integer[] meseint = new Integer[12+1];
        Integer[] giornoint = new Integer[31+1];

        for(int i = 1; i <= giornoint.length-1; i++){
            giornoint[i] = i;
        }
        for(int i = 1; i <= meseint.length-1; i++){
            meseint[i] = i;
        }
        for(int i = 1; i <= annoint.length-1; i++){
            annoint[i] = i+1979;
        }
        anno=new JComboBox<>(annoint);
        mese=new JComboBox<>(meseint);
        giorno=new JComboBox<>(giornoint);

        /*String[] prova = {"1", "2", "3"};

        comboBox = new JComboBox(prova);*/

        /*int i=1980;

        for(i;i<2023;i++) {
            anno.add(i);
        }
        i=0;
        for(i;i<12;i++) {
            mese.add(i);
        }
        i=0;
        for(i;i<31;i++) {
            giorno.add(i);
        }*/

        add(nomeTart);
        add(anno);
        add(mese);
        add(giorno);

        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
