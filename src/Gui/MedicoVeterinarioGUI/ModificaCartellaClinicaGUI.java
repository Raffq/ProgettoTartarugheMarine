package Gui.MedicoVeterinarioGUI;

import ClassiPrincipali.Personale;
import ClassiPrincipali.Tartaruga;
import Controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModificaCartellaClinicaGUI extends JPanel {
    private JTable listaTartarughe;
    private JTextField specie;
    private JTextField lunghezza;
    private JTextField larghezza;
    private JTextField peso;
    private JTextField luogoRitrovamento;

    private JLabel specieLabel, lunghezzaLabel, larghezzaLabel, pesoLabel, luogoRitrovamentoLabel;
    private JButton conferma;
    private Personale personale;
    private DefaultTableModel model;
    private Controller controller;
    public ModificaCartellaClinicaGUI() {
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        controller = new Controller();


        model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        listaTartarughe = new JTable(model);
        model.addColumn("Targhetta");
        model.addColumn("Nome");

        JScrollPane scrollPane = new JScrollPane(listaTartarughe);


        specieLabel = new JLabel("specie");
        lunghezzaLabel = new JLabel("lunghezza");
        larghezzaLabel = new JLabel("larghezza");
        pesoLabel = new JLabel("peso");
        luogoRitrovamentoLabel = new JLabel("luogoRit");
        conferma = new JButton("conferma");

        specie = new JTextField(20);
        lunghezza = new JTextField(20);
        larghezza = new JTextField(20);
        peso = new JTextField(20);
        luogoRitrovamento = new JTextField(20);

        conferma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tartarugaScelta = (String) listaTartarughe.getValueAt(listaTartarughe.getSelectedRow(), 0);
                String specieScelta = specie.getText();
                String lunghezzaSceltaTemp = lunghezza.getText();
                int lunghezzaScelta = Integer.parseInt(lunghezzaSceltaTemp);
                String larghezzaSceltaTemp = larghezza.getText();
                int larghezzaScelta = Integer.parseInt(larghezzaSceltaTemp);
                String pesoSceltoTemp = peso.getText();
                int pesoScelto = Integer.parseInt(pesoSceltoTemp);
                String luogoRitrovamentoScelto = luogoRitrovamento.getText();

                try {
                    controller.compileLastCartellaClinica(tartarugaScelta, specieScelta,lunghezzaScelta, larghezzaScelta, pesoScelto, luogoRitrovamentoScelto, personale.getMatricola());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        JPanel labelsPanel = new JPanel();
        JPanel fieldsPanel = new JPanel();
        labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS));
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.Y_AXIS));

        add(scrollPane);

        labelsPanel.add(specieLabel);
        fieldsPanel.add(specie);
        labelsPanel.add(new Box.Filler(new Dimension(2, 2), new Dimension(2, 2), new Dimension(2, 2)));
        labelsPanel.add(lunghezzaLabel);
        fieldsPanel.add(lunghezza);
        labelsPanel.add(new Box.Filler(new Dimension(2, 2), new Dimension(2, 2), new Dimension(2, 2)));
        labelsPanel.add(larghezzaLabel);
        fieldsPanel.add(larghezza);
        labelsPanel.add(new Box.Filler(new Dimension(2, 2), new Dimension(2, 2), new Dimension(2, 2)));
        labelsPanel.add(pesoLabel);
        fieldsPanel.add(peso);
        labelsPanel.add(new Box.Filler(new Dimension(2, 2), new Dimension(2, 2), new Dimension(2, 2)));
        labelsPanel.add(luogoRitrovamentoLabel);
        fieldsPanel.add(luogoRitrovamento);

        JPanel fixPanel = new JPanel();
        fixPanel.add(labelsPanel);
        fixPanel.add(fieldsPanel);
        add(fixPanel);

        add(conferma);

    }

    public void populateListaTartarughe()
    {
        try {
            ArrayList<Tartaruga> data = new ArrayList<>();
            data = controller.getTartarugheNelCentro(personale.getfkidcentro(), true);

            for(Tartaruga i : data){
                model.addRow(new Object[]{i.getTarghetta(), i.getNomeTartaruga()});
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void setPersonale(Personale personale) {
        this.personale = personale;
    }

}
