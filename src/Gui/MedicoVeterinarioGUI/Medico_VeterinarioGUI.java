package Gui.MedicoVeterinarioGUI;

import Gui.OperatoreGUI.AmmettiGUI;

import javax.swing.*;

public class Medico_VeterinarioGUI extends JPanel {
    private CompilaComponentiGUI compilaComponentiPanel;
    private CompilaCartellaClinicaGUI compilaCartellaClinicaPanel;

    private ModificaComponentiGUI modificaComponentiPanel;
    private ModificaCartellaClinicaGUI modificaCartellaClinicaPanel;

    public Medico_VeterinarioGUI() {
        compilaComponentiPanel = new CompilaComponentiGUI();
        add(compilaComponentiPanel);
        compilaComponentiPanel.setVisible(false);

        compilaCartellaClinicaPanel = new CompilaCartellaClinicaGUI();
        add(compilaCartellaClinicaPanel);
        compilaCartellaClinicaPanel.setVisible(false);

        modificaComponentiPanel = new ModificaComponentiGUI();
        add(modificaComponentiPanel);
        modificaComponentiPanel.setVisible(false);

        modificaCartellaClinicaPanel = new ModificaCartellaClinicaGUI();
        add(modificaCartellaClinicaPanel);
        modificaCartellaClinicaPanel.setVisible(false);

    }

    public void showCompilaComponenti()
    {
        compilaCartellaClinicaPanel.setVisible(false);
        modificaComponentiPanel.setVisible(false);
        modificaCartellaClinicaPanel.setVisible(false);

        compilaComponentiPanel.setVisible(true);
    }
    public CompilaComponentiGUI getCompilaComponentiPanel() {
        return compilaComponentiPanel;
    }

    public void showCompilaCartellaClinica()
    {
        compilaComponentiPanel.setVisible(false);
        modificaComponentiPanel.setVisible(false);
        modificaCartellaClinicaPanel.setVisible(false);

        compilaCartellaClinicaPanel.setVisible(true);
    }

    public CompilaCartellaClinicaGUI getCompilaCartellaClinicaPanel() {
        return compilaCartellaClinicaPanel;
    }

    public void showModificaComponenti()
    {
        compilaComponentiPanel.setVisible(false);
        compilaCartellaClinicaPanel.setVisible(false);
        modificaCartellaClinicaPanel.setVisible(false);

        modificaComponentiPanel.setVisible(true);
    }


    public ModificaComponentiGUI getModificaComponentiPanel() {
        return modificaComponentiPanel;
    }

    public void showModificaCartellaClinica()
    {
        compilaComponentiPanel.setVisible(false);
        compilaCartellaClinicaPanel.setVisible(false);
        modificaComponentiPanel.setVisible(false);

        modificaCartellaClinicaPanel.setVisible(true);
    }

    public ModificaCartellaClinicaGUI getModificaCartellaClinicaPanel() {
        return modificaCartellaClinicaPanel;
    }
}