package Gui.MedicoVeterinarioGUI;

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

public class CompilaComponentiTemp extends JFrame {
    private JLabel becco, collo, testa, coda, pinne, occhi, naso;
    private JComboBox condizioneBecco, condizioneCollo, condizioneTesta, condizioneCoda, condizionePinne, condizioneOcchi, condizioneNaso;
    private JDatePanelImpl datePanel;
    private JDatePickerImpl datePicker;
    private JButton conferma;
    private JTable listaTartarughe;
    public CompilaComponentiTemp(Personale personale) throws SQLException {
        super("Compila componenti tartaruga");
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

        becco = new JLabel("becco");
        collo = new JLabel("collo");
        testa = new JLabel("testa");
        coda = new JLabel("coda");
        pinne = new JLabel("pinne");
        occhi = new JLabel("occhi");
        naso = new JLabel("naso");

        String[] condizioneString = {" ", "compromesso", "ferite profonde", "ferite superficiali", "buono", "perfetto"};
        condizioneBecco = new JComboBox(condizioneString);
        condizioneCollo = new JComboBox(condizioneString);
        condizioneTesta = new JComboBox(condizioneString);
        condizioneCoda = new JComboBox(condizioneString);
        condizionePinne = new JComboBox(condizioneString);
        condizioneOcchi = new JComboBox(condizioneString);
        condizioneNaso = new JComboBox(condizioneString);

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

        add(becco);
        add(condizioneBecco);
        add(collo);
        add(condizioneCollo);
        add(testa);
        add(condizioneTesta);
        add(coda);
        add(condizioneCoda);
        add(pinne);
        add(condizionePinne);
        add(occhi);
        add(condizioneOcchi);
        add(naso);
        add(condizioneNaso);
        add(conferma);

        conferma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCellValue = (String) listaTartarughe.getValueAt(listaTartarughe.getSelectedRow(),0);
                Date selectedDate = (Date) datePicker.getModel().getValue();
                java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());

                String selectedCondizioneBecco = (String) condizioneBecco.getSelectedItem();
                String selectedCondizioneCollo = (String) condizioneCollo.getSelectedItem();
                String selectedCondizioneTesta = (String) condizioneTesta.getSelectedItem();
                String selectedCondizioneCoda = (String) condizioneCoda.getSelectedItem();
                String selectedCondizionePinne = (String) condizionePinne.getSelectedItem();
                String selectedCondizioneOcchi = (String) condizioneOcchi.getSelectedItem();
                String selectedCondizioneNaso = (String) condizioneNaso.getSelectedItem();
                try {
                    controller.compileComponenti(selectedCellValue, sqlDate, selectedCondizioneBecco, selectedCondizioneCollo, selectedCondizioneTesta, selectedCondizioneCoda, selectedCondizionePinne, selectedCondizioneOcchi, selectedCondizioneNaso);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
