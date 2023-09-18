package Gui.OperatoreGUI;


import ClassiPrincipali.Personale;
import DAO.Operatore.OperatoreDAOImpl;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import Controller.Controller;

public class AmmettiTemp extends JFrame {
    private JTextField nomeTart;
    private JButton conferma;
    private JDatePanelImpl datePanel;
    private JDatePickerImpl datePicker;

    public AmmettiTemp(Personale personale) {
        super("Ammissione tartaruga");

        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        nomeTart = new JTextField(15);
        conferma = new JButton("conferma");

        add(nomeTart);
        add(conferma);

        UtilDateModel model = new UtilDateModel();
        java.util.Date today = new Date();
        model.setDate(today.getYear(), today.getMonth(), today.getDay());
        model.setSelected(true);
        Properties p  = new Properties();
        p.put("text.day", "Day");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, null);
        datePicker.setBounds(110, 100, 200, 25);
        datePicker.setVisible(true);

        add(datePicker);

        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Controller controller = new Controller();
        conferma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Date selectedDate = (Date) datePicker.getModel().getValue();
                    java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
                    controller.ammetti(nomeTart.getText(), personale.getfkidcentro(), sqlDate);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}