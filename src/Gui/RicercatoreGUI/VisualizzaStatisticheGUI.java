package Gui.RicercatoreGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import Controller.Controller;

public class VisualizzaStatisticheGUI extends JPanel {
    private JLabel statBecco, statCollo, statTesta, statCoda, statPinne, statOcchi, statNaso;
    private JLabel textBecco, textCollo, textTesta, textCoda, textPinne, textOcchi, textNaso;

    private JLabel annoLabel, meseLabel, condizioneLabel;

    private JComboBox sceltaMese, sceltaAnno, sceltaCondizione;
    Integer statBeccoNumero, statColloNumero, statTestaNumero, statCodaNumero, statPinneNumero, statOcchiNumero, statNasoNumero;
    Integer meseScelto, annoScelto;
    String condizioneScelta;
    private JButton mese, anno;
    public VisualizzaStatisticheGUI() {
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

        condizioneLabel = new JLabel("Scegli condizione:");
        annoLabel = new JLabel("Scegli anno:");
        meseLabel = new JLabel("scegli mese:");

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


        JPanel labelsPanel = new JPanel();
        JPanel fieldsPanel = new JPanel();
        labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS));
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.Y_AXIS));

        labelsPanel.add(textBecco);
        fieldsPanel.add(statBecco);
        labelsPanel.add(textCollo);
        fieldsPanel.add(statCollo);
        labelsPanel.add(textTesta);
        fieldsPanel.add(statTesta);
        labelsPanel.add(textCoda);
        fieldsPanel.add(statCoda);
        labelsPanel.add(textPinne);
        fieldsPanel.add(statPinne);
        labelsPanel.add(textOcchi);
        fieldsPanel.add(statOcchi);
        labelsPanel.add(textNaso);
        fieldsPanel.add(statNaso);

        add(meseLabel);
        add(sceltaMese);
        add(annoLabel);
        add(sceltaAnno);
        add(condizioneLabel);
        add(sceltaCondizione);


        add(mese);
        add(anno);

        JPanel fixPanel = new JPanel();
        fixPanel.add(labelsPanel);
        fixPanel.add(fieldsPanel);
        add(fixPanel);

        mese.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                meseScelto = (Integer) sceltaMese.getSelectedItem();
                annoScelto = (Integer) sceltaAnno.getSelectedItem();
                condizioneScelta = (String) sceltaCondizione.getSelectedItem();

                try {
                    statBeccoNumero = controller.countTartarugheCondizioneBeccoMese(condizioneScelta, meseScelto, annoScelto);
                    statColloNumero = controller.countTartarugheCondizioneColloMese(condizioneScelta, meseScelto, annoScelto);
                    statTestaNumero = controller.countTartarugheCondizioneTestaMese(condizioneScelta, meseScelto, annoScelto);
                    statCodaNumero = controller.countTartarugheCondizioneCodaMese(condizioneScelta, meseScelto, annoScelto);
                    statPinneNumero = controller.countTartarugheCondizionePinneMese(condizioneScelta, meseScelto, annoScelto);
                    statOcchiNumero = controller.countTartarugheCondizioneOcchiMese(condizioneScelta, meseScelto, annoScelto);
                    statNasoNumero = controller.countTartarugheCondizioneNasoMese(condizioneScelta, meseScelto, annoScelto);
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
                    statColloNumero = controller.countTartarugheCondizioneColloAnno(condizioneScelta, annoScelto);
                    statTestaNumero = controller.countTartarugheCondizioneTestaAnno(condizioneScelta, annoScelto);
                    statCodaNumero = controller.countTartarugheCondizioneCodaAnno(condizioneScelta, annoScelto);
                    statPinneNumero = controller.countTartarugheCondizionePinneAnno(condizioneScelta, annoScelto);
                    statOcchiNumero = controller.countTartarugheCondizioneOcchiAnno(condizioneScelta, annoScelto);
                    statNasoNumero = controller.countTartarugheCondizioneNasoAnno(condizioneScelta, annoScelto);
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
        setVisible(true);
    }
}
