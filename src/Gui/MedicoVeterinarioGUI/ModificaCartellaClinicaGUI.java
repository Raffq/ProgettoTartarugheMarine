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

public class ModificaCartellaClinicaGUI extends JFrame {
    private JTable listaCartelleCliniche;
    private JTextField specie;
    private JTextField lunghezza;
    private JTextField larghezza;
    private JTextField peso;
    private JTextField luogoRitrovamento;
    private JButton conferma;
    public ModificaCartellaClinicaGUI(Personale personale) throws SQLException {
        super("Modifica cartella clinica tartaruga");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        Controller controller = new Controller();

        listaCartelleCliniche = new JTable();
        Object[] columns = {"idcartellecliniche", "matricola"};
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        model.setColumnIdentifiers(columns);
        ArrayList<Cartella_Clinica> data = new ArrayList<>();
        data = controller.getCartelleCliniche();

        for(Cartella_Clinica i : data){
            model.addRow(new Object[]{i.getIdCartellaClinica(), i.getFkMatricolamv()});
        }

        listaCartelleCliniche.setModel(model);

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
                String cartellaClinicaScelta = (String) listaCartelleCliniche.getValueAt(listaCartelleCliniche.getSelectedRow(), 0);
                String specieScelta = specie.getText();
                String lunghezzaSceltaTemp = lunghezza.getText();
                int lunghezzaScelta = Integer.parseInt(lunghezzaSceltaTemp);
                String larghezzaSceltaTemp = larghezza.getText();
                int larghezzaScelta = Integer.parseInt(larghezzaSceltaTemp);
                String pesoSceltoTemp = peso.getText();
                int pesoScelto = Integer.parseInt(pesoSceltoTemp);
                String luogoRitrovamentoScelto = luogoRitrovamento.getText();

                try {
                    controller.updateCartellaClinica(cartellaClinicaScelta, specieScelta,lunghezzaScelta, larghezzaScelta, pesoScelto, luogoRitrovamentoScelto, personale.getMatricola());
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
