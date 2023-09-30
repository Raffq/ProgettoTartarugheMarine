package Gui.MedicoVeterinarioGUI;

import javax.swing.*;

    public class MedicoVeterinarioButtonsGUI extends JPanel {

        private JButton compilaComponente;
        private JButton compilaCartellaClinica;
        private JButton modificaComponente;
        private JButton modificaCartellaClinica;

        public MedicoVeterinarioButtonsGUI()
        {
            compilaComponente = new JButton("Compila componenti");
            compilaCartellaClinica = new JButton("Compila cartella clinica");
            modificaComponente = new JButton("Modifica componenti");
            modificaCartellaClinica = new JButton("Modifica cartella clinica");

            add(compilaComponente);
            add(compilaCartellaClinica);
            add(modificaComponente);
            add(modificaCartellaClinica);
        }

        public JButton getCompilaComponente() {
            return compilaComponente;
        }

        public JButton getCompilaCartellaClinica() {
            return compilaCartellaClinica;
        }

        public JButton getModificaComponente() {
            return modificaComponente;
        }

        public JButton getModificaCartellaClinica() {
            return modificaCartellaClinica;
        }
    }
