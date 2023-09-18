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

public class CompilaCartellaClinicaTemp extends JFrame {
    private JTable listaTartarughe;
    private JTextField specie;
    private JTextField lunghezza;
    private JTextField larghezza;
    private JTextField peso;
    private JTextField luogoRitrovamento;
    private JButton conferma;
    public CompilaCartellaClinicaTemp(Personale personale) throws SQLException {
        /*super("Compila cartella clinica tartaruga");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        Controller controller = new Controller();

        listaTartarughe = new JTable();
        Object[] columns = {"Targhetta", "Nome"};
        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columns);
        ArrayList<Tartaruga> data = new ArrayList<>();
        data = controller.getTartarugheNelCentro(personale.getfkidcentro(), true);

        for(Tartaruga i : data){
            model.addRow(new Object[]{i});
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

         */
    }
}
