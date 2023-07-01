package Gui;

import javax.swing.*;
import java.time.chrono.JapaneseDate;

public class AmmettiTemp extends JFrame {
    private JTextField nomeTart;
    private JComboBox anno;
    private JComboBox mese;
    private JComboBox giorno;
    public AmmettiTemp() {
        super("Ammetti");

        nomeTart=new JTextField();
        anno=new JComboBox<>();
        mese=new JComboBox<>();
        giorno=new JComboBox<>();

        int i=1980;

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
        }


        add(nomeTart);
        add(anno);
        add(mese);
        add(giorno);
    }
}
