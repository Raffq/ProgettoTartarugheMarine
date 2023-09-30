package Gui.MedicoVeterinarioGUI;

import ClassiPrincipali.Cartella_Clinica;
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
    private JTable listaCartelleCliniche;
    private JTextField specie;
    private JTextField lunghezza;
    private JTextField larghezza;
    private JTextField peso;
    private JTextField luogoRitrovamento;
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

        listaCartelleCliniche = new JTable(model);
        model.addColumn("IdCartellaClinica");
        model.addColumn("Targhetta");

        JScrollPane scrollPane = new JScrollPane(listaCartelleCliniche);

        specie = new JTextField("specie");
        lunghezza = new JTextField("lunghezza");
        larghezza = new JTextField("larghezza");
        peso = new JTextField("peso");
        luogoRitrovamento = new JTextField("luogoRit");
        conferma = new JButton("conferma");

        conferma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tartarugaScelta = (String) listaCartelleCliniche.getValueAt(listaCartelleCliniche.getSelectedRow(), 0);
                String specieScelta = specie.getText();
                String lunghezzaSceltaTemp = lunghezza.getText();
                int lunghezzaScelta = Integer.parseInt(lunghezzaSceltaTemp);
                String larghezzaSceltaTemp = larghezza.getText();
                int larghezzaScelta = Integer.parseInt(larghezzaSceltaTemp);
                String pesoSceltoTemp = peso.getText();
                int pesoScelto = Integer.parseInt(pesoSceltoTemp);
                String luogoRitrovamentoScelto = luogoRitrovamento.getText();

                try {
                    controller.updateCartellaClinica(tartarugaScelta, specieScelta,lunghezzaScelta, larghezzaScelta, pesoScelto, luogoRitrovamentoScelto, personale.getMatricola());
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
            ArrayList<Cartella_Clinica> data = new ArrayList<>();
            data = controller.getCartelleCliniche();

            for(Cartella_Clinica i : data){
                model.addRow(new Object[]{i.getIdCartellaClinica(), i.getFktarghetta()});
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void setPersonale(Personale personale) {
        this.personale = personale;
    }

}