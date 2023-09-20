package Controller;

import ClassiPrincipali.*;
import DAO.Medico_Veterinario.Medico_VeterinarioDAO;
import DAO.Medico_Veterinario.Medico_VeterinarioDAOImpl;
import DAO.Operatore.OperatoreDAO;
import DAO.Operatore.OperatoreDAOImpl;
import DAO.Ricercatore.RicercatoreDAO;
import DAO.Ricercatore.RicercatoreDAOImpl;
import DAO.Tartaruga.TartarugaDAOImpl;
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
import Gui.RicercatoreGUI.RicercatoreTemp;
import Gui.RicercatoreGUI.VisualizzaStatisticheTemp;
import Gui.TecnicoLaboratorioGUI.Tecnico_LaboratorioTemp;

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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
                goToMedico_Veterinario(personale);
            } else if (personale instanceof Tecnico_Laboratorio) {
                goToTecnico_Laboratorio();
            } else if (personale instanceof Ricercatore) {
                goToRicercatore();
            }
        }
        //schermate principali
        public void goToMedico_Veterinario(Personale personale){
            Medico_VeterinarioTemp mvt = new Medico_VeterinarioTemp(personale);
            mvt.setVisible(true);
        }
        public void goToOperatore(Personale personale){
            OperatoreTemp mvt = new OperatoreTemp(personale);
            mvt.setVisible(true);
        }
        public void goToRicercatore(){
            RicercatoreTemp ri = new RicercatoreTemp();
            ri.setVisible(true);
        }
        public void goToTecnico_Laboratorio(){
            Tecnico_LaboratorioTemp tl = new Tecnico_LaboratorioTemp();
            tl.setVisible(true);
        }

        //medico veterinario
        public void goToCompilaCartellaClinica(Personale personale) throws SQLException {
            CompilaCartellaClinicaTemp ccct = new CompilaCartellaClinicaTemp(personale);
            ccct.setVisible(true);
        }
        public void goToCompilaComponenti(Personale personale) throws SQLException {
            CompilaComponentiTemp cct = new CompilaComponentiTemp(personale);
            cct.setVisible(true);
        }
        //Operatore
        public void goToAmmetti(Personale personale) {
            AmmettiTemp ammetti = new AmmettiTemp(personale);
            ammetti.setVisible(true);
        }
        public void goToRiammetti(Personale personale) throws SQLException {
            RiammettiTemp riammetti = new RiammettiTemp(personale);
            riammetti.setVisible(true);
        }
        public void goToRilascia(Personale personale) throws SQLException {
            RilasciaTemp rilasciaTemp = new RilasciaTemp(personale);
            rilasciaTemp.setVisible(true);
        }
        //Ricercatore
        public void goToStatistiche() {
            VisualizzaStatisticheTemp visualizzaStatistiche = new VisualizzaStatisticheTemp();
            visualizzaStatistiche.setVisible(true);
        }
        //metodi Operatore
        public void ammetti(String nome, String idCentro, Date data) throws SQLException {
            OperatoreDAOImpl operatoreDAO = new OperatoreDAOImpl();
            operatoreDAO.ammetti(nome, idCentro, data);
        }
        public void riammetti(String idTar, Date data) throws SQLException {
            OperatoreDAOImpl operatoreDAO = new OperatoreDAOImpl();
            operatoreDAO.riammetti(idTar, data);
        }
        public void rilascia(String idTar, Date data) throws SQLException {
            OperatoreDAOImpl operatoreDAO = new OperatoreDAOImpl();
            operatoreDAO.rilascia(idTar, data);
        }
        //tartarughe metodi
        public ArrayList<Tartaruga> getTartarugheNelCentro(String idCen, boolean presenteNelCentro) throws SQLException {
            ArrayList<Tartaruga> tartarughe = new ArrayList<>();
            TartarugaDAOImpl tartarugaDAO = new TartarugaDAOImpl();
            tartarughe = tartarugaDAO.getTartarugheNelCentro(idCen, presenteNelCentro);
            return tartarughe;
        }
        //medico veterinario metodi
        public void compileLastCartellaClinica(String idTartaruga, String specie, int lunghezza, int larghezza, int peso, String luogo_ritrovamento, String matricola) throws SQLException {
            Medico_VeterinarioDAOImpl medicoVeterinarioDAO = new Medico_VeterinarioDAOImpl();
            medicoVeterinarioDAO.compileLastCartellaClinica(idTartaruga, specie, lunghezza, larghezza, peso, luogo_ritrovamento, matricola);
        }
        public void compileComponenti(String idTartaruga, String descBecco, String descCollo, String descTesta, String descCoda, String descPinne, String descOcchi, String descNaso, Date dataCompilazione) throws SQLException {
            Medico_VeterinarioDAOImpl medicoVeterinarioDAO = new Medico_VeterinarioDAOImpl();
            medicoVeterinarioDAO.compileComponenti(idTartaruga, descBecco, descCollo, descTesta, descCoda, descPinne, descOcchi, descNaso, dataCompilazione);
        }
        public void updateCartellaClinica(String idCartellaClinica, String specie, int lunghezza, int larghezza, int peso, String luogo_ritrovamento, String matricola) throws SQLException {
            Medico_VeterinarioDAOImpl medicoVeterinarioDAO = new Medico_VeterinarioDAOImpl();
            medicoVeterinarioDAO.updateCartellaClinica(idCartellaClinica, specie, lunghezza, larghezza, peso, luogo_ritrovamento, matricola);
        }
        public void updateComponenti(String idComponenti, Date dataCompilazione, String descBecco, String descCollo, String descTesta, String descCoda, String descPinne, String descOcchi, String descNaso) throws SQLException {
            Medico_VeterinarioDAOImpl medicoVeterinarioDAO = new Medico_VeterinarioDAOImpl();
            medicoVeterinarioDAO.updateComponenti(idComponenti, dataCompilazione, descBecco, descCollo, descTesta, descCoda, descPinne, descOcchi, descNaso);
        }
}
