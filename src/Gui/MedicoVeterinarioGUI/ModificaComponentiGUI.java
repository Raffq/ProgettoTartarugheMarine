package Gui.MedicoVeterinarioGUI;

import ClassiPrincipali.Personale;
import ClassiPrincipali.Tartaruga;
import Controller.Controller;
import Gui.MainWindow.DatePicker;
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

public class ModificaComponentiGUI extends JPanel {
    private JLabel becco, collo, testa, coda, pinne, occhi, naso;
    private JComboBox condizioneBecco, condizioneCollo, condizioneTesta, condizioneCoda, condizionePinne, condizioneOcchi, condizioneNaso;
    private JDatePickerImpl datePicker;
    private JButton conferma;
    private JTable listaTartarughe;
    private DefaultTableModel tableModel;
    private Controller controller;
    private Personale personale;
    public ModificaComponentiGUI() {
        controller = new Controller();

        tableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        listaTartarughe = new JTable(tableModel);
        tableModel.addColumn("Targhetta");
        tableModel.addColumn("Nome");

        add(new JScrollPane(listaTartarughe), BorderLayout.LINE_START);

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

        datePicker = new DatePicker().Calendar();
        add(datePicker);

        conferma = new JButton("conferma");

        JPanel labelsPanel = new JPanel();
        JPanel condizionePanel = new JPanel();
        labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS));
        condizionePanel.setLayout(new BoxLayout(condizionePanel, BoxLayout.Y_AXIS));


        labelsPanel.add(becco);
        condizionePanel.add(condizioneBecco);
        labelsPanel.add(new Box.Filler(new Dimension(10, 10), new Dimension(10, 10), new Dimension(10, 10)));
        labelsPanel.add(collo);
        condizionePanel.add(condizioneCollo);
        labelsPanel.add(new Box.Filler(new Dimension(10, 10), new Dimension(10, 10), new Dimension(10, 10)));
        labelsPanel.add(testa);
        condizionePanel.add(condizioneTesta);
        labelsPanel.add(new Box.Filler(new Dimension(10, 10), new Dimension(10, 10), new Dimension(10, 10)));
        labelsPanel.add(coda);
        condizionePanel.add(condizioneCoda);
        labelsPanel.add(new Box.Filler(new Dimension(10, 10), new Dimension(10, 10), new Dimension(10, 10)));
        labelsPanel.add(pinne);
        condizionePanel.add(condizionePinne);
        labelsPanel.add(new Box.Filler(new Dimension(10, 10), new Dimension(10, 10), new Dimension(10, 10)));
        labelsPanel.add(occhi);
        condizionePanel.add(condizioneOcchi);
        labelsPanel.add(new Box.Filler(new Dimension(10, 10), new Dimension(10, 10), new Dimension(10, 10)));
        labelsPanel.add(naso);
        condizionePanel.add(condizioneNaso);
        labelsPanel.add(new Box.Filler(new Dimension(10, 10), new Dimension(10, 10), new Dimension(10, 10)));

        JPanel fixPanel = new JPanel();
        fixPanel.add(labelsPanel);
        fixPanel.add(condizionePanel);

        add(fixPanel);
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
    }

    public void populateListaTartarughe()
    {
        try {
            ArrayList<Tartaruga> tartarughe = controller.getTartarugheNelCentro(personale.getfkidcentro(), true);

            for (Tartaruga i: tartarughe) {
                tableModel.addRow(new Object[] { i.getTarghetta() , i.getNomeTartaruga()});
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void setPersonale(Personale personale) {
        this.personale = personale;
    }

}