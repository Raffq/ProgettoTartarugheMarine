package Gui.MainWindow;

import ClassiPrincipali.*;
import Controller.Controller;
import Gui.AccediGUI;
import Gui.OperatoreGUI.AmmettiGUI;
import Gui.OperatoreGUI.RiammettiGUI;
import Gui.OperatoreGUI.RilasciaGUI;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class MainWindow extends JFrame {

    public Controller controller;
    public Personale ps;
    public MainWindow(Controller c) throws SQLException {
        super("Tartarughe");
        this.controller = c;

        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(1400,800);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(null);
        mainPanel.setLayout(new BorderLayout(0, 0));

        setVisible(true);

        // MIDDLE PANEL
        JPanel middlePanel = new JPanel();

        AmmettiGUI ammettiPanel = new AmmettiGUI();
        middlePanel.add(ammettiPanel);
        ammettiPanel.setVisible(false);

        RiammettiGUI riammettiPanel = new RiammettiGUI();
        mainPanel.add(riammettiPanel);
        riammettiPanel.setVisible(false);

        RilasciaGUI rilasciaPanel = new RilasciaGUI();
        rilasciaPanel.add(riammettiPanel);
        rilasciaPanel.setVisible(false);

        // TOP PANEL
        JPanel topPanel = new JPanel();
        // OPERATORE

        JButton ammettiButton = new JButton("Ametti");
        JButton riammettiButton = new JButton("Riammetti");
        JButton rilasciaButton = new JButton("Rilascia");

        topPanel.add(ammettiButton);
        topPanel.add(riammettiButton);
        topPanel.add(rilasciaButton);

        ammettiButton.setVisible(false);
        riammettiButton.setVisible(false);
        rilasciaButton.setVisible(false);

        // MEDICO VETERINARIO

        JButton compilaComponente = new JButton("Compila componenti");
        JButton compilaCartellaClinica = new JButton("Compila cartella clinica");
        JButton modificaComponente = new JButton("Modifica componenti");
        JButton modificaCartellaClinica = new JButton("Modifica cartella clinica");

        topPanel.add(compilaComponente);
        topPanel.add(compilaCartellaClinica);
        topPanel.add(modificaComponente);
        topPanel.add(modificaCartellaClinica);

        compilaComponente.setVisible(false);
        compilaCartellaClinica.setVisible(false);
        modificaComponente.setVisible(false);
        modificaCartellaClinica.setVisible(false);

        // RICERCATORE

        JButton visualizzaStatistiche = new JButton("Visualizza statistiche");

        topPanel.add(visualizzaStatistiche);

        visualizzaStatistiche.setVisible(false);

        // TECNICO_LABORATORIO

        JButton aggiungiVasca = new JButton("Aggiungi Vasca");

        topPanel.add(aggiungiVasca);

        aggiungiVasca.setVisible(false);

        // RIGHT PANEL
        JButton loginButton = new JButton("Accedi");
        JTextField loginMatricola = new JTextField();
        JLabel accediLabel = new JLabel("Inserisci matricola");

        AccediGUI rightPanel = new AccediGUI(loginButton, loginMatricola, accediLabel);

        loginButton.addActionListener(e -> {


            try {
                String loginMatricolaString = loginMatricola.getText();
                ps = controller.controllaMatricola(loginMatricolaString);

                if(ps != null) {

                    if(ps instanceof Operatore) {
                        ammettiButton.setVisible(true);
                        riammettiButton.setVisible(true);
                        rilasciaButton.setVisible(true);

                        compilaComponente.setVisible(false);
                        compilaCartellaClinica.setVisible(false);
                        modificaComponente.setVisible(false);
                        modificaCartellaClinica.setVisible(false);
                        visualizzaStatistiche.setVisible(false);
                        aggiungiVasca.setVisible(false);

                        ammettiButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                riammettiPanel.setVisible(false);
                                rilasciaPanel.setVisible(false);

                                ammettiPanel.setVisible(true);
                                ammettiPanel.SetPersonale(ps);


                            }
                        });

                        riammettiButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                ammettiPanel.setVisible(false);
                                rilasciaPanel.setVisible(false);

                                riammettiPanel.setVisible(true);

                                riammettiPanel.SetPersonale(ps);
                                riammettiPanel.populateListaTartarughe();
                            }
                        });

                        rilasciaButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                ammettiPanel.setVisible(false);
                                riammettiPanel.setVisible(false);

                                rilasciaPanel.setVisible(true);

                                rilasciaPanel.SetPersonale(ps);
                                rilasciaPanel.populateListaTartarughe();
                            }
                        });
                    }
                    if(ps instanceof Medico_Veterinario) {
                        compilaComponente.setVisible(true);
                        compilaCartellaClinica.setVisible(true);
                        modificaComponente.setVisible(true);
                        modificaCartellaClinica.setVisible(true);

                        ammettiButton.setVisible(false);
                        riammettiButton.setVisible(false);
                        rilasciaButton.setVisible(false);
                        visualizzaStatistiche.setVisible(false);
                        aggiungiVasca.setVisible(false);

                        compilaComponente.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //compilaComponentiPanel.setPersonale(ps);

                                //compilaCartellaClinicaPanel.setVisible(false);
                                //compilaComponentiPanel.setVisible(true);
                                //modificaCartellaClinicaPanel.setVisible(false);
                                //modificaComponentiPanel.setVisible(false);
                            }
                        });
                        compilaCartellaClinica.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //compilaCartellaClinicaPanel.setPersonale(ps);

                                //compilaCartellaClinicaPanel.setVisible(true);
                                //compilaComponentiPanel.setVisible(false);
                                //modificaCartellaClinicaPanel.setVisible(false);
                                //modificaComponentiPanel.setVisible(false);
                            }
                        });
                        modificaComponente.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //compilaCartellaClinicaPanel.setVisible(false);
                                //compilaComponentiPanel.setVisible(false);
                                //modificaCartellaClinicaPanel.setVisible(false);
                                //modificaComponentiPanel.setVisible(true);
                            }
                        });
                        modificaCartellaClinica.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //compilaCartellaClinicaPanel.setVisible(false);
                                //compilaComponentiPanel.setVisible(false);
                                //modificaCartellaClinicaPanel.setVisible(true);
                                //modificaComponentiPanel.setVisible(false);
                            }
                        });


                    }
                    if(ps instanceof Ricercatore) {
                        visualizzaStatistiche.setVisible(true);

                        compilaComponente.setVisible(false);
                        compilaCartellaClinica.setVisible(false);
                        modificaComponente.setVisible(false);
                        modificaCartellaClinica.setVisible(false);
                        ammettiButton.setVisible(false);
                        riammettiButton.setVisible(false);
                        rilasciaButton.setVisible(false);
                        aggiungiVasca.setVisible(false);

                        visualizzaStatistiche.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                controller.goToStatistiche();
                            }
                        });
                    }
                    if(ps instanceof Tecnico_Laboratorio) {
                        aggiungiVasca.setVisible(true);

                        visualizzaStatistiche.setVisible(false);
                        compilaComponente.setVisible(false);
                        compilaCartellaClinica.setVisible(false);
                        modificaComponente.setVisible(false);
                        modificaCartellaClinica.setVisible(false);
                        ammettiButton.setVisible(false);
                        riammettiButton.setVisible(false);
                        rilasciaButton.setVisible(false);

                        aggiungiVasca.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {


                            }
                        });
                    }
                }
                else {
                    accediLabel.setForeground(Color.RED);
                    accediLabel.setText("Matricola errata!");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        topPanel.setPreferredSize(new Dimension(1400, 100));
        rightPanel.setPreferredSize(new Dimension(300, 600));
        //middlePanel.setPreferredSize(new Dimension(1200, 700));

        topPanel.setBackground(Color.lightGray);
        rightPanel.setBackground(Color.CYAN);

        add(topPanel, BorderLayout.PAGE_START);
        add(middlePanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.LINE_END);
    }
}

