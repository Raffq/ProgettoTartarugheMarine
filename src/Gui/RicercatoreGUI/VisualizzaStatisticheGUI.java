package Gui.RicercatoreGUI;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import Controller.Controller;

public class VisualizzaStatisticheGUI extends JFrame {
    private JLabel statBecco, statCollo, statTesta, statCoda, statPinne, statOcchi, statNaso;
    private JLabel textBecco, textCollo, textTesta, textCoda, textPinne, textOcchi, textNaso;

    private JComboBox sceltaMese, sceltaAnno, sceltaCondizione;
    Integer statBeccoNumero, statColloNumero, statTestaNumero, statCodaNumero, statPinneNumero, statOcchiNumero, statNasoNumero;
    Integer meseScelto, annoScelto;
    String condizioneScelta;
    private JButton mese, anno;


    public VisualizzaStatisticheGUI() {
        super("Visualizzazione statistiche");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        Controller controller = new Controller();

        textBecco = new JLabel("Becco");
        textCollo = new JLabel("Collo");
        textTesta = new JLabel("Testa");
        textCoda = new JLabel("Coda");
        textPinne = new JLabel("Pinne");
        textOcchi = new JLabel("Occhi");
        textNaso = new JLabel("Naso");

        statBecco = new JLabel();
        statCollo = new JLabel();
        statTesta = new JLabel();
        statCoda = new JLabel();
        statPinne = new JLabel();
        statOcchi = new JLabel();
        statNaso = new JLabel();

        ArrayList<Integer> listaMesi = new ArrayList<>();
        ArrayList<Integer> listaAnni = new ArrayList<>();

        for(int i = 1; i <= 12; i++) {
            listaMesi.add(i);
        }
        for(int i = 2023; i >= 1980; i--){
            listaAnni.add(i);
        }

        sceltaMese = new JComboBox(listaMesi.toArray());
        sceltaAnno = new JComboBox(listaAnni.toArray());

        String[] condizioni = {"compromesso", "ferite profonde", "ferite superficiali", "buono", "perfetto"};

        sceltaCondizione = new JComboBox<>(condizioni);

        mese = new JButton("Mensile");
        anno = new JButton("Annuale");

        add(textBecco);
        add(statBecco);
        add(textCollo);
        add(statCollo);
        add(textTesta);
        add(statTesta);
        add(textCoda);
        add(statCoda);
        add(textPinne);
        add(statPinne);
        add(textOcchi);
        add(statOcchi);
        add(textNaso);
        add(statNaso);
        add(sceltaMese);
        add(sceltaAnno);
        add(sceltaCondizione);

        add(mese);
        add(anno);

        mese.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                meseScelto = (Integer) sceltaMese.getSelectedItem();
                annoScelto = (Integer) sceltaAnno.getSelectedItem();
                condizioneScelta = (String) sceltaCondizione.getSelectedItem();

                try {
                    statBeccoNumero = controller.countTartarugheCondizioneBeccoMese(condizioneScelta, meseScelto, annoScelto);
                    statColloNumero = controller.countTartarugheCondizioneBeccoMese(condizioneScelta, meseScelto, annoScelto);
                    statTestaNumero = controller.countTartarugheCondizioneBeccoMese(condizioneScelta, meseScelto, annoScelto);
                    statCodaNumero = controller.countTartarugheCondizioneBeccoMese(condizioneScelta, meseScelto, annoScelto);
                    statPinneNumero = controller.countTartarugheCondizioneBeccoMese(condizioneScelta, meseScelto, annoScelto);
                    statOcchiNumero = controller.countTartarugheCondizioneBeccoMese(condizioneScelta, meseScelto, annoScelto);
                    statNasoNumero = controller.countTartarugheCondizioneBeccoMese(condizioneScelta, meseScelto, annoScelto);
                } catch (SQLException e2) {
                    throw new RuntimeException();
                }

                statBecco.setText(statBeccoNumero.toString());
                statCollo.setText(statColloNumero.toString());
                statTesta.setText(statTestaNumero.toString());
                statCoda.setText(statCodaNumero.toString());
                statPinne.setText(statPinneNumero.toString());
                statOcchi.setText(statOcchiNumero.toString());
                statNaso.setText(statNasoNumero.toString());
            }
        });

        anno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                annoScelto = (Integer) sceltaAnno.getSelectedItem();
                condizioneScelta = (String) sceltaCondizione.getSelectedItem();

                try {
                    statBeccoNumero = controller.countTartarugheCondizioneBeccoAnno(condizioneScelta, annoScelto);
                    statColloNumero = controller.countTartarugheCondizioneBeccoAnno(condizioneScelta, annoScelto);
                    statTestaNumero = controller.countTartarugheCondizioneBeccoAnno(condizioneScelta, annoScelto);
                    statCodaNumero = controller.countTartarugheCondizioneBeccoAnno(condizioneScelta, annoScelto);
                    statPinneNumero = controller.countTartarugheCondizioneBeccoAnno(condizioneScelta, annoScelto);
                    statOcchiNumero = controller.countTartarugheCondizioneBeccoAnno(condizioneScelta, annoScelto);
                    statNasoNumero = controller.countTartarugheCondizioneBeccoAnno(condizioneScelta, annoScelto);
                } catch (SQLException e2) {
                    throw new RuntimeException();
                }

                statBecco.setText(statBeccoNumero.toString());
                statCollo.setText(statColloNumero.toString());
                statTesta.setText(statTestaNumero.toString());
                statCoda.setText(statCodaNumero.toString());
                statPinne.setText(statPinneNumero.toString());
                statOcchi.setText(statOcchiNumero.toString());
                statNaso.setText(statNasoNumero.toString());
            }
        });

        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
