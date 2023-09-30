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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RiammettiGUI extends JPanel {
    private JTable listaTartarughe;
    private JButton conferma;
    private JDatePanelImpl datePanel;
    private JDatePickerImpl datePicker;
    private Personale personale;
    private Controller controller;
    private DefaultTableModel tableModel;

    public RiammettiGUI() {
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
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String selectedCellValue = (String) listaTartarughe.getValueAt(listaTartarughe.getSelectedRow(), 0);
                    Date selectedDate = dateFormat.parse(datePicker.getJFormattedTextField().getText());
                    java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
                    controller.riammetti(selectedCellValue, sqlDate);
                } catch (SQLException | ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public void populateListaTartarughe() {
        try {
            ArrayList<Tartaruga> tartarughe = controller.getTartarugheNelCentro(personale.getfkidcentro(), false);

            for (Tartaruga i: tartarughe) {
                this.tableModel.addRow(new Object[]{i.getTarghetta(), i.getNomeTartaruga()});
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void SetPersonale(Personale personale) {
        this.personale = personale;
    }
}
