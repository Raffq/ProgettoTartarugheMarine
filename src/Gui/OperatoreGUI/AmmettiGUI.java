package Gui.OperatoreGUI;

import ClassiPrincipali.Personale;
import Gui.MainWindow.DatePicker;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import Controller.Controller;

public class AmmettiGUI extends JPanel {
    private JTextField nomeTart;
    private JButton conferma;
    private JDatePickerImpl datePicker;
    private Personale personale;
    private Controller controller;

    public AmmettiGUI() {
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        controller = new Controller();

        nomeTart = new JTextField(15);
        conferma = new JButton("conferma");


        add(nomeTart);
        add(conferma);
        datePicker = new DatePicker().Calendar();
        add(datePicker);
        setSize(800, 500);
        setVisible(true);


        conferma.addActionListener(e -> {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date selectedDate = dateFormat.parse(datePicker.getJFormattedTextField().getText());
                java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
                controller.ammetti(nomeTart.getText(), personale.getfkidcentro(), sqlDate);
            } catch (SQLException | ParseException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
    public void SetPersonale(Personale personale) {
        this.personale = personale;
    }
}