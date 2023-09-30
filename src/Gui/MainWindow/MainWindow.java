package Gui.MainWindow;

import ClassiPrincipali.*;
import Controller.Controller;
import Gui.AccediGUI;
import Gui.MedicoVeterinarioGUI.MedicoVeterinarioButtonsGUI;
import Gui.MedicoVeterinarioGUI.Medico_VeterinarioGUI;
import Gui.OperatoreGUI.*;
import Gui.RicercatoreGUI.RicercatoreButtonsGUI;
import Gui.RicercatoreGUI.RicercatoreGUI;
import Gui.TecnicoLaboratorioGUI.Tecnico_LaboratorioButtonsGUI;
import Gui.TecnicoLaboratorioGUI.Tecnico_LaboratorioGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainWindow extends JFrame {

    public Controller controller;
    public Personale membroPersonale;
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

        // TOP PANEL
        JPanel topPanel = new JPanel();
        OperatoreButtonsGUI operatoreButtons = new OperatoreButtonsGUI();
        operatoreButtons.setVisible(false);
        topPanel.add(operatoreButtons);
        MedicoVeterinarioButtonsGUI medicoVeterinarioButtons = new MedicoVeterinarioButtonsGUI();
        medicoVeterinarioButtons.setVisible(false);
        topPanel.add(medicoVeterinarioButtons);
        RicercatoreButtonsGUI ricercatoreButtons = new RicercatoreButtonsGUI();
        ricercatoreButtons.setVisible(false);
        topPanel.add(ricercatoreButtons);
        Tecnico_LaboratorioButtonsGUI tecnicoLaboratorioButtons = new Tecnico_LaboratorioButtonsGUI();
        tecnicoLaboratorioButtons.setVisible(false);
        topPanel.add(tecnicoLaboratorioButtons);

        // MIDDLE PANEL
        JPanel middlePanel = new JPanel();
        OperatoreGUI operatoriPanels = new OperatoreGUI();
        middlePanel.add(operatoriPanels);
        operatoriPanels.setVisible(false);
        Medico_VeterinarioGUI medicoVeterinarioPanels = new Medico_VeterinarioGUI();
        middlePanel.add(medicoVeterinarioPanels);
        medicoVeterinarioPanels.setVisible(false);
        RicercatoreGUI ricercatoriPanels = new RicercatoreGUI();
        middlePanel.add(ricercatoriPanels);
        ricercatoriPanels.setVisible(false);
        Tecnico_LaboratorioGUI tecnicoLaboratorioPanels = new Tecnico_LaboratorioGUI();
        middlePanel.add(tecnicoLaboratorioPanels);
        tecnicoLaboratorioPanels.setVisible(false);

        // RIGHT PANEL
        AccediGUI rightPanel = new AccediGUI();
        rightPanel.getButtonLogin().addActionListener(e -> {
            try {
                String loginMatricolaString = rightPanel.getLoginMatricola().getText();
                membroPersonale = controller.controllaMatricola(loginMatricolaString);

                if(membroPersonale != null) {

                    if(membroPersonale instanceof Operatore) {
                        medicoVeterinarioButtons.setVisible(false);
                        ricercatoreButtons.setVisible(false);
                        tecnicoLaboratorioButtons.setVisible(false);

                        medicoVeterinarioPanels.setVisible(false);
                        ricercatoriPanels.setVisible(false);
                        tecnicoLaboratorioPanels.setVisible(false);

                        operatoreButtons.setVisible(true);
                        operatoriPanels.setVisible(true);

                        operatoreButtons.getAmmettiButton().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                operatoriPanels.showAmmetti();
                                operatoriPanels.getAmmettiPanel().SetPersonale(membroPersonale);
                            }
                        });

                        operatoreButtons.getRiammettiButton().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                operatoriPanels.showRiAmmetti();
                                operatoriPanels.getRiammettiPanel().SetPersonale(membroPersonale);
                                operatoriPanels.getRiammettiPanel().populateListaTartarughe();
                            }
                        });

                        operatoreButtons.getRilasciaButton().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                operatoriPanels.showRilascia();
                                operatoriPanels.getRilasciaPanel().SetPersonale(membroPersonale);
                                operatoriPanels.getRilasciaPanel().populateListaTartarughe();
                            }
                        });
                    }
                    else if(membroPersonale instanceof Medico_Veterinario) {
                        operatoreButtons.setVisible(false);
                        ricercatoreButtons.setVisible(false);
                        tecnicoLaboratorioButtons.setVisible(false);

                        operatoriPanels.setVisible(false);
                        ricercatoriPanels.setVisible(false);
                        tecnicoLaboratorioPanels.setVisible(false);

                        medicoVeterinarioButtons.setVisible(true);
                        medicoVeterinarioPanels.setVisible(true);

                        medicoVeterinarioButtons.getCompilaComponente().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                medicoVeterinarioPanels.showCompilaComponenti();
                                medicoVeterinarioPanels.getCompilaComponentiPanel().setPersonale(membroPersonale);
                                medicoVeterinarioPanels.getCompilaComponentiPanel().populateListaTartarughe();
                            }
                        });
                        medicoVeterinarioButtons.getCompilaCartellaClinica().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                medicoVeterinarioPanels.showCompilaCartellaClinica();
                                medicoVeterinarioPanels.getCompilaCartellaClinicaPanel().setPersonale(membroPersonale);
                                medicoVeterinarioPanels.getCompilaCartellaClinicaPanel().populateListaTartarughe();
                            }
                        });
                        medicoVeterinarioButtons.getModificaComponente().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                medicoVeterinarioPanels.showModificaComponenti();
                                medicoVeterinarioPanels.getModificaComponentiPanel().setPersonale(membroPersonale);
                                medicoVeterinarioPanels.getModificaComponentiPanel().populateListaTartarughe();
                            }
                        });
                        medicoVeterinarioButtons.getModificaCartellaClinica().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                medicoVeterinarioPanels.showModificaCartellaClinica();
                                medicoVeterinarioPanels.getModificaCartellaClinicaPanel().setPersonale(membroPersonale);
                                medicoVeterinarioPanels.getModificaCartellaClinicaPanel().populateListaTartarughe();
                            }
                        });
                    }
                    else if(membroPersonale instanceof Ricercatore) {
                        operatoreButtons.setVisible(false);
                        medicoVeterinarioButtons.setVisible(false);
                        tecnicoLaboratorioButtons.setVisible(false);

                        operatoriPanels.setVisible(false);
                        medicoVeterinarioPanels.setVisible(false);
                        tecnicoLaboratorioPanels.setVisible(false);

                        ricercatoreButtons.setVisible(true);
                        ricercatoriPanels.setVisible(true);

                        ricercatoreButtons.getVisualizzaStatistiche().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                ricercatoriPanels.showvisualizzaStatistiche();
                                // TO DO
                            }
                        });
                    }
                    else if(membroPersonale instanceof Tecnico_Laboratorio) {
                        operatoreButtons.setVisible(false);
                        medicoVeterinarioButtons.setVisible(false);
                        ricercatoreButtons.setVisible(false);

                        operatoriPanels.setVisible(false);
                        medicoVeterinarioPanels.setVisible(false);
                        ricercatoriPanels.setVisible(false);

                        tecnicoLaboratorioButtons.setVisible(true);
                        tecnicoLaboratorioPanels.setVisible(true);

                        tecnicoLaboratorioButtons.getAggiungiVasca().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                tecnicoLaboratorioPanels.showAggiungiVasche();
                                // TO DO
                            }
                        });
                    }
                }
                else {
                    rightPanel.getAccediLabel().setForeground(Color.RED);
                    rightPanel.getAccediLabel().setText("Matricola errata!");

                    operatoriPanels.setVisible(false);
                    medicoVeterinarioPanels.setVisible(false);
                    ricercatoriPanels.setVisible(false);
                    tecnicoLaboratorioPanels.setVisible(true);

                    operatoreButtons.setVisible(false);
                    medicoVeterinarioButtons.setVisible(false);
                    ricercatoreButtons.setVisible(false);
                    tecnicoLaboratorioButtons.setVisible(false);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        topPanel.setPreferredSize(new Dimension(1400, 100));
        rightPanel.setPreferredSize(new Dimension(300, 700));
        middlePanel.setPreferredSize(new Dimension(1100, 700));

        topPanel.setBackground(Color.lightGray);

        add(topPanel, BorderLayout.PAGE_START);
        add(middlePanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.LINE_END);

        setVisible(true);
    }
}


