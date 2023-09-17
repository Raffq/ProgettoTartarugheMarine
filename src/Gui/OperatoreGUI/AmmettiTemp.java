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

public class AmmettiTemp extends JFrame {
    private JTextField nomeTart;
    /*private JComboBox anno;
    private JComboBox mese;
    private JComboBox giorno;

     */
    private JButton conferma;


    public AmmettiTemp(Personale personale) {
        super("Ammissione tartaruga");

        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        nomeTart = new JTextField(15);

        conferma = new JButton("conferma");

        /*Integer[] annoint = new Integer[2023 - 1979 + 1];
        Integer[] meseint = new Integer[12 + 1];
        Integer[] giornoint = new Integer[31 + 1];

       int annoValue=0;
        int meseValue=0;
        int giornoValue=0;

        for (int i = 1; i <= giornoint.length - 1; i++) {
            giornoint[i] = i;
        }
        for (int i = 1; i <= meseint.length - 1; i++) {
            meseint[i] = i;
        }
        for (int i = 1; i <= annoint.length - 1; i++) {
            annoint[i] = i + 1979;
        }
        anno = new JComboBox<>(annoint);
        mese = new JComboBox<>(meseint);
        giorno = new JComboBox<>(giornoint);

         annoValue= (int) anno.getSelectedItem();
        meseValue= (int) mese.getSelectedItem();
        giornoValue= (int) giorno.getSelectedItem();


        add(anno);
        add(mese);
        add(giorno);


         */

        add(nomeTart);
        add(conferma);

        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, new Properties());
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        add(datePicker);
        Date selectedDate = (Date) datePicker.getModel().getValue();

        Calendar selectedValue = (Calendar) datePicker.getModel().getValue();
        java.sql.Date sqlDate=new java.sql.Date((java.sql.Date)datePicker.getModel().getValue());


        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        OperatoreDAOImpl operatoreDAOImpl = new OperatoreDAOImpl();
        conferma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println(nomeTart.getText());
                    System.out.println(personale.getfkidcentro());
                    System.out.println(selectedDate);
                    operatoreDAOImpl.ammetti(nomeTart.getText(), personale.getfkidcentro(), sqlDate);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
