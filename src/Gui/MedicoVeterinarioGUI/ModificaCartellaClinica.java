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

public class ModificaCartellaClinica extends JFrame {
    private JTable listaTartarughe;
    private JTextField specie;
    private JTextField lunghezza;
    private JTextField larghezza;
    private JTextField peso;
    private JTextField luogoRitrovamento;
    private JButton conferma;
    public ModificaCartellaClinica(Personale personale) throws SQLException {
        super("Modifica cartella clinica tartaruga");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        Controller controller = new Controller();

        listaTartarughe = new JTable();
        Object[] columns = {"Targhetta", "Nome"};
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        model.setColumnIdentifiers(columns);
        ArrayList<Tartaruga> data = new ArrayList<>();
        data = controller.getTartarugheNelCentro(personale.getfkidcentro(), true);

        for(Tartaruga i : data){
            model.addRow(new Object[]{i.getTarghetta(), i.getNomeTartaruga()});
        }

        listaTartarughe.setModel(model);

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

        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
