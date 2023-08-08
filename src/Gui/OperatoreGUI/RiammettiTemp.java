package Gui.OperatoreGUI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class RiammettiTemp extends JFrame {
    private JTable listaTartarughe;
    private JComboBox anno;
    private JComboBox mese;
    private JComboBox giorno;
    private JButton conferma;
    String[] colonneTable;
    Object[][] data;


    public RiammettiTemp(){
        super("Riammissione tartaruga");

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

        Integer[] annoint = new Integer[2023-1979+1];
        Integer[] meseint = new Integer[12+1];
        Integer[] giornoint = new Integer[31+1];

        for(int i = 1; i <= giornoint.length-1; i++){
            giornoint[i] = i;
        }
        for(int i = 1; i <= meseint.length-1; i++){
            meseint[i] = i;
        }
        for(int i = 1; i <= annoint.length-1; i++){
            annoint[i] = i+1979;
        }
        conferma = new JButton("conferma");
        anno=new JComboBox<>(annoint);
        mese=new JComboBox<>(meseint);
        giorno=new JComboBox<>(giornoint);

        add(scrollPane);
        add(anno);
        add(mese);
        add(giorno);
        add(conferma);

        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
