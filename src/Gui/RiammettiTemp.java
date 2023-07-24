package Gui;
import javax.swing.*;
import java.awt.*;

public class RiammettiTemp extends JFrame {
    private JTable tartarugheNelCentro;
    private JComboBox anno;
    private JComboBox mese;
    private JComboBox giorno;
    String[] colonneTable;
    Object[][] data;


    public RiammettiTemp(){
        super("Riammissione");

        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        colonneTable = new String[2];
        String[] colonneTable = {"Nome", "Targhetta"};

        data = new Object[2][2];
        Object[][] data = {{"test1", "test2"},{"test3", "test4"},{"test1", "test2"},{"test1", "test2"},{"test1", "test2"},};

        tartarugheNelCentro = new JTable(data, colonneTable);

        JScrollPane scrollPane = new JScrollPane(tartarugheNelCentro);
        tartarugheNelCentro.setFillsViewportHeight(true);

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
        anno=new JComboBox<>(annoint);
        mese=new JComboBox<>(meseint);
        giorno=new JComboBox<>(giornoint);

        add(tartarugheNelCentro);
        add(anno);
        add(mese);
        add(giorno);

        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
