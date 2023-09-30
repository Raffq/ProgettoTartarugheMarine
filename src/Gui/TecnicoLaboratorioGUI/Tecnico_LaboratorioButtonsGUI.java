package Gui.TecnicoLaboratorioGUI;

import javax.swing.*;

    public class Tecnico_LaboratorioButtonsGUI extends JPanel {

        private JButton aggiungiVasca;

        public Tecnico_LaboratorioButtonsGUI()
        {
            aggiungiVasca = new JButton("Aggiungi Vasca");
            add(aggiungiVasca);
        }

        public JButton getAggiungiVasca() {
            return aggiungiVasca;
        }
}



