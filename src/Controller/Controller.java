package Controller;

import ClassiPrincipali.*;
import DAO.Medico_Veterinario.Medico_VeterinarioDAO;
import DAO.Medico_Veterinario.Medico_VeterinarioDAOImpl;
import DAO.Operatore.OperatoreDAO;
import DAO.Operatore.OperatoreDAOImpl;
import DAO.Ricercatore.RicercatoreDAO;
import DAO.Ricercatore.RicercatoreDAOImpl;
import DAO.Tecnico_Laboratorio.Tecnico_LaboratorioDAO;
import DAO.Tecnico_Laboratorio.Tecnico_LaboratorioDAOImpl;
import Gui.AccediTemp;
import Gui.MedicoVeterinarioGUI.CompilaCartellaClinicaTemp;
import Gui.MedicoVeterinarioGUI.CompilaComponentiTemp;
import Gui.MedicoVeterinarioGUI.Medico_VeterinarioTemp;
import Gui.OperatoreGUI.AmmettiTemp;
import Gui.OperatoreGUI.OperatoreTemp;
import Gui.OperatoreGUI.RiammettiTemp;
import Gui.OperatoreGUI.RilasciaTemp;
import Gui.RicercatoreGUI.VisualizzaStatisticheTemp;

import javax.swing.*;
import java.sql.SQLException;
import java.text.ParseException;

public class Controller {
    AccediTemp accediTemp; //TEST
    public Controller() {}
        public Personale controllaMatricola(String MatricolaTemp) throws SQLException {
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
            } else if (MatricolaTemp.substring(0, 2).equals("RI")) {
                RicercatoreDAO ricercatoreDAO = new RicercatoreDAOImpl();
                Personale ricercatore = ricercatoreDAO.get(MatricolaTemp);

                return ricercatore;
            } else {
                return null;
            }
        }
        //accedi
        public void accedi (Personale personale){
            if (personale instanceof Operatore) {
                goToOperatore(personale);
            } else if (personale instanceof Medico_Veterinario) {
                goToMedico_Veterinario();
            } else if (personale instanceof Tecnico_Laboratorio) {
                goToTecnico_Laboratorio();
            } else if (personale instanceof Ricercatore) {
                goToRicercatore();
            }
        }

        public void goToMedico_Veterinario(){
            Medico_VeterinarioTemp mvt = new Medico_VeterinarioTemp();
            mvt.setVisible(true);
        }
        public void goToOperatore(Personale personale){
            OperatoreTemp mvt = new OperatoreTemp(personale);
            mvt.setVisible(true);
        }
        public void goToRicercatore(){
            Medico_VeterinarioTemp mvt = new Medico_VeterinarioTemp();
            mvt.setVisible(true);
        }
        public void goToTecnico_Laboratorio(){
            Medico_VeterinarioTemp mvt = new Medico_VeterinarioTemp();
            mvt.setVisible(true);
        }

        //medico veterinario
        public void goToCompilaCartellaClinica(){
            CompilaCartellaClinicaTemp ccct = new CompilaCartellaClinicaTemp();
            ccct.setVisible(true);
        }
        public void goToCompilaComponenti() {
            CompilaComponentiTemp cct = new CompilaComponentiTemp();
            cct.setVisible(true);
        }
        //Operatore
        public void goToAmmetti(Personale personale) {
            AmmettiTemp ammetti = new AmmettiTemp(personale);
            ammetti.setVisible(true);
        }
        public void goToRiammetti() {
            RiammettiTemp riammetti = new RiammettiTemp();
            riammetti.setVisible(true);
        }
        public void goToRilascia() {
            RilasciaTemp rilasciaTemp = new RilasciaTemp();
            rilasciaTemp.setVisible(true);
        }
        //Ricercatore
        public void goToStatistiche() {
            VisualizzaStatisticheTemp visualizzaStatistiche = new VisualizzaStatisticheTemp();
            visualizzaStatistiche.setVisible(true);
        }
}
