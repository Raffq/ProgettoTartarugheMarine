package Gui.OperatoreGUI;

import ClassiPrincipali.Personale;
import ClassiPrincipali.Tartaruga;
import Controller.Controller;
import Gui.MainWindow.DatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class RilasciaGUI extends JPanel {
    private JTable listaTartarughe;
    private JButton conferma;
    private JDatePickerImpl datePicker;

    private Personale personale;
    private Controller controller;

    private DefaultTableModel tableModel;

    public RilasciaGUI() {

        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        controller = new Controller();

        tableModel = new DefaultTableModel(){
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

        datePicker = new DatePicker().Calendar();
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
    }

    public void populateListaTartarughe()
    {
        tableModel.setRowCount(0);
        ArrayList<Tartaruga> tartarughe = null;
        try {
            tartarughe = controller.getTartarugheNelCentro(personale.getfkidcentro(), true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (Tartaruga i: tartarughe) {
            tableModel.addRow(new Object[] { i.getTarghetta() , i.getNomeTartaruga()});
        }
    }
    public void SetPersonale(Personale personale) {
        this.personale = personale;
    }
}