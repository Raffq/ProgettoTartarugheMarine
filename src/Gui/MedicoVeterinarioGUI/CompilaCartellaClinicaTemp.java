package Gui.MedicoVeterinarioGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CompilaCartellaClinicaTemp extends JFrame {
    private JTable listaTartarughe;
    private JTextField specie;
    private JTextField lunghezza;
    private JTextField larghezza;
    private JTextField peso;
    private JTextField luogoRitrovamento;
    private JButton conferma;
    public CompilaCartellaClinicaTemp() {
        super("Compila cartella clinica tartaruga");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        listaTartarughe = new JTable();
        Object[] columns = {"Targhetta", "Nome"};
        DefaultTableModel model = new DefaultTableModel(columns,10);

        model.setColumnIdentifiers(columns);
        //test data
        Object[][] data = {{"IdTar1", "NomeTar1"},{"IdTar2", "NomeTar2"},{"IdTar3", "NomeTar3"}};
        model.addRow(data);

        listaTartarughe.setModel(model);

        JScrollPane scrollPane = new JScrollPane(listaTartarughe);

        specie = new JTextField("specie");
        lunghezza = new JTextField("lunghezza");
        larghezza = new JTextField("larghezza");
        peso = new JTextField("peso");
        luogoRitrovamento = new JTextField("luogoRit");
        conferma = new JButton("conferma");

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
