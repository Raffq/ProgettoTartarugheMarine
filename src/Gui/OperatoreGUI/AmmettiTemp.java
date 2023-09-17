package Gui.OperatoreGUI;

import ClassiPrincipali.Operatore;
import ClassiPrincipali.Personale;
import DAO.Operatore.OperatoreDAO;
import DAO.Operatore.OperatoreDAOImpl;
import java.sql.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.chrono.JapaneseDate;
import java.util.GregorianCalendar;

public class AmmettiTemp extends JFrame {
    private JTextField nomeTart;
    private JComboBox anno;
    private JComboBox mese;
    private JComboBox giorno;
    private JComboBox comboBox;
    private JButton conferma;
    public AmmettiTemp(Personale personale) {
        super("Ammissione tartaruga");

        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        setLayout(flowLayout);

        nomeTart=new JTextField(15);

        conferma = new JButton("conferma");

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

        add(nomeTart);
        add(anno);
        add(mese);
        add(giorno);
        add(conferma);

        String giornoSt=giorno.toString();
        String meseSt=mese.toString();
        String annoSt=anno.toString();
        String Data = annoSt+'-'+meseSt+'-'+giornoSt;


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
                    operatoreDAOImpl.ammetti(nomeTart.getText(), personale.getfkidcentro(), Data);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
