package Controller;

import ClassiPrincipali.*;
import DAO.Medico_Veterinario.Medico_VeterinarioDAO;
import DAO.Medico_Veterinario.Medico_VeterinarioDAOImpl;
import DAO.Operatore.OperatoreDAO;
import DAO.Operatore.OperatoreDAOImpl;
import DAO.Tecnico_Laboratorio.Tecnico_LaboratorioDAO;
import DAO.Tecnico_Laboratorio.Tecnico_LaboratorioDAOImpl;
import Gui.AccediTemp;
import Gui.MedicoVeterinarioGUI.CompilaCartellaClinicaTemp;
import Gui.MedicoVeterinarioGUI.CompilaComponentiTemp;
import Gui.OperatoreGUI.AmmettiTemp;
import Gui.OperatoreGUI.OperatoreTemp;
import Gui.OperatoreGUI.RiammettiTemp;
import Gui.OperatoreGUI.RilasciaTemp;
import Gui.RicercatoreGUI.VisualizzaStatisticheTemp;

import javax.swing.*;
import java.sql.SQLException;

public class Controller {
    AccediTemp accediTemp;
    OperatoreTemp operatoreTemp;
    public Controller() {}
        Personale controllaMatricola (String MatricolaTemp) throws SQLException {
            if (MatricolaTemp.substring(0, 2).equals("OP")) {
                OperatoreDAO operatoreDAO = new OperatoreDAOImpl();
                Personale operatore = operatoreDAO.get(MatricolaTemp);

                return operatore;
            } else if (MatricolaTemp.substring(0, 2).equals("TL")) {
                Tecnico_LaboratorioDAO tecnico_laboratorioDAO = new Tecnico_LaboratorioDAOImpl();
                Personale tecnico_laboratorio = tecnico_laboratorioDAO.get(MatricolaTemp);


                return tecnico_laboratorio;
            } else if (MatricolaTemp.substring(0, 2).equals("MV")) {
                Medico_VeterinarioDAO medico_veterinarioDAO = new Medico_VeterinarioDAOImpl();
                Personale medico_veterinario = medico_veterinarioDAO.get(MatricolaTemp);

                return medico_veterinario;
            } else {
                return null;
            }
        }

        void accedi (Personale personale){
            if (personale instanceof Operatore) {
                System.out.println("OpenInterfaccia");
            } else if (personale instanceof Medico_Veterinario) {
                System.out.println("OpenInterfaccia");
            } else if (personale instanceof Tecnico_Laboratorio) {
                System.out.println("OpenInterfaccia");
            }
        }
        //medico veterinario
        void goToCompilaCartellaClinica(JFrame frame){
            frame.dispose();
            CompilaCartellaClinicaTemp ccct = new CompilaCartellaClinicaTemp();
            ccct.setVisible(true);
        }
        void goToCompilaComponenti(JFrame frame) {
            frame.dispose();
            CompilaComponentiTemp cct = new CompilaComponentiTemp();
            cct.setVisible(true);
        }
        //Operatore
        void goToAmmetti(JFrame frame) {
            frame.dispose();
            AmmettiTemp ammetti = new AmmettiTemp();
            ammetti.setVisible(true);
        }
        void goToRiammetti(JFrame frame) {
            frame.dispose();
            RiammettiTemp riammetti = new RiammettiTemp();
            riammetti.setVisible(true);
        }
        void goToRilascia(JFrame frame) {
            frame.dispose();
            RilasciaTemp rilasciaTemp = new RilasciaTemp();
            rilasciaTemp.setVisible(true);
        }
        //Ricercatore
        void goToStatistiche(JFrame frame) {
            frame.dispose();
            VisualizzaStatisticheTemp visualizzaStatistiche = new VisualizzaStatisticheTemp();
            visualizzaStatistiche.setVisible(true);
        }
}
