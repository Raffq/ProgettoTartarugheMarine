package Gui.OperatoreGUI;
import DAO.Operatore.OperatoreDAOImpl;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

public class RiammettiTemp extends JFrame {
    private JTable listaTartarughe;
    private JButton conferma;
    String[] colonneTable;
    Object[][] data;
    private JDatePanelImpl datePanel;
    private JDatePickerImpl datePicker;


    public RiammettiTemp(){
        super("Riammissione tartaruga");

        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        listaTartarughe = new JTable();
        Object[] columns = {"Targhetta", "Nome"};
        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columns);
        //test data
        // = ;
        model.addRow(data);

        listaTartarughe.setCellSelectionEnabled(false);
        listaTartarughe.setRowSelectionAllowed(true);
        listaTartarughe.setDefaultEditor(Object.class, null);
        listaTartarughe.setModel(model);

        JScrollPane scrollPane = new JScrollPane(listaTartarughe);

        /*UtilDateModel modelDate = new UtilDateModel();
        java.util.Date today = new Date();
        modelDate.setDate(today.getYear(), today.getMonth(), today.getDay());
        modelDate.setSelected(true);
        Properties p  = new Properties();
        p.put("text.day", "Day");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        datePanel = new JDatePanelImpl(modelDate, p);*/
        datePicker = new JDatePickerImpl(datePanel, null);
        datePicker.setBounds(110, 100, 200, 25);
        datePicker.setVisible(true);

        conferma = new JButton("conferma");

        add(scrollPane);
        add(datePicker);
        add(conferma);

        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        OperatoreDAOImpl operatoreDAOImpl = new OperatoreDAOImpl();
        /*conferma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Date selectedDate = (Date) datePicker.getModel().getValue();
                    java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
                    operatoreDAOImpl.riammetti(, sqlDate);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });*/

    }

}
