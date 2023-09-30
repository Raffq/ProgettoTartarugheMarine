package Gui.OperatoreGUI;

import ClassiPrincipali.Personale;
import ClassiPrincipali.Tartaruga;
import Controller.Controller;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

public class RilasciaGUI extends JFrame {
    private JTable listaTartarughe;
    private JButton conferma;
    private JDatePanelImpl datePanel;
    private JDatePickerImpl datePicker;


    public RilasciaGUI(Personale personale) throws SQLException {
        super("Rilascio tartaruga");

        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        Controller controller = new Controller();

        DefaultTableModel tableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        listaTartarughe = new JTable(tableModel);
        tableModel.addColumn("Targhetta");
        tableModel.addColumn("Nome");

        add(new JScrollPane(listaTartarughe));

        ArrayList<Tartaruga> tartarughe = controller.getTartarugheNelCentro(personale.getfkidcentro(), true);

        for (Tartaruga i: tartarughe) {
            tableModel.addRow(new Object[] { i.getTarghetta() , i.getNomeTartaruga()});
        }

        UtilDateModel modelDate = new UtilDateModel();
        java.util.Date today = new Date();
        modelDate.setDate(today.getYear(), today.getMonth(), today.getDay());
        modelDate.setSelected(true);
        Properties p  = new Properties();
        p.put("text.day", "Day");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        datePanel = new JDatePanelImpl(modelDate, p);
        datePicker = new JDatePickerImpl(datePanel, null);
        datePicker.setBounds(110, 100, 200, 25);
        datePicker.setVisible(true);
        add(datePicker);

        conferma = new JButton("conferma");
        add(conferma);

        conferma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCellValue = (String) listaTartarughe.getValueAt(listaTartarughe.getSelectedRow(), 0);
                Date selectedDate = (Date) datePicker.getModel().getValue();
                java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
                try {
                    controller.rilascia(selectedCellValue, sqlDate);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

