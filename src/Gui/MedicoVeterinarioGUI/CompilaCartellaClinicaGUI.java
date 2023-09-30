package Gui.MedicoVeterinarioGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import ClassiPrincipali.Personale;
import ClassiPrincipali.Tartaruga;
import Controller.Controller;

public class CompilaCartellaClinicaGUI extends JPanel {
    private JTable listaTartarughe;
    private JTextField specie;
    private JTextField lunghezza;
    private JTextField larghezza;
    private JTextField peso;
    private JTextField luogoRitrovamento;
    private JButton conferma;
    private Controller controller;
    private Personale personale;
    private DefaultTableModel tableModel;

    public CompilaCartellaClinicaGUI() {
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        controller = new Controller();

        tableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        listaTartarughe = new JTable(tableModel);
        tableModel.addColumn("Targhetta");
        tableModel.addColumn("Nome");


        JScrollPane scrollPane = new JScrollPane(listaTartarughe);

        specie = new JTextField("specie");
        lunghezza = new JTextField("lunghezza");
        larghezza = new JTextField("larghezza");
        peso = new JTextField("peso");
        luogoRitrovamento = new JTextField("luogoRit");
        conferma = new JButton("conferma");

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

        add(scrollPane);
        add(specie);
        add(lunghezza);
        add(larghezza);
        add(peso);
        add(luogoRitrovamento);
        add(conferma);

    }

    public void populateListaTartarughe()
    {
        try {
            ArrayList<Tartaruga> data = new ArrayList<>();

                data = controller.getTartarugheNelCentro(personale.getfkidcentro(), true);

            for(Tartaruga i : data){
                this.tableModel.addRow(new Object[]{i.getTarghetta(), i.getNomeTartaruga()});
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void setPersonale(Personale personale) {
        this.personale = personale;
    }
}

