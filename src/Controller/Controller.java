package Controller;

import ClassiPrincipali.*;
import DAO.Cartella_Clinica.Cartella_ClinicaDAOImpl;
import DAO.Componenti.ComponentiDAOImpl;
import DAO.Medico_Veterinario.Medico_VeterinarioDAO;
import DAO.Medico_Veterinario.Medico_VeterinarioDAOImpl;
import DAO.Operatore.OperatoreDAO;
import DAO.Operatore.OperatoreDAOImpl;
import DAO.Ricercatore.RicercatoreDAO;
import DAO.Ricercatore.RicercatoreDAOImpl;
import DAO.Tartaruga.TartarugaDAOImpl;
import DAO.Tecnico_Laboratorio.Tecnico_LaboratorioDAO;
import DAO.Tecnico_Laboratorio.Tecnico_LaboratorioDAOImpl;
import Gui.AccediGUI;
import Gui.MedicoVeterinarioGUI.*;
import Gui.OperatoreGUI.AmmettiGUI;
//import Gui.OperatoreGUI.OperatoreGUI;
import Gui.OperatoreGUI.RiammettiGUI;
import Gui.OperatoreGUI.RilasciaGUI;
import Gui.RicercatoreGUI.RicercatoreGUI;
import Gui.RicercatoreGUI.VisualizzaStatisticheGUI;
import Gui.TecnicoLaboratorioGUI.Tecnico_LaboratorioGUI;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controller {
    AccediGUI accedi; //TEST
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
        public void compileComponenti(String idTartaruga, Date dataCompilazione, String descBecco, String descCollo, String descTesta, String descCoda, String descPinne, String descOcchi, String descNaso) throws SQLException {
            Medico_VeterinarioDAOImpl medicoVeterinarioDAO = new Medico_VeterinarioDAOImpl();
            medicoVeterinarioDAO.compileComponenti(idTartaruga, dataCompilazione, descBecco, descCollo, descTesta, descCoda, descPinne, descOcchi, descNaso);
        }
        public void updateCartellaClinica(String idCartellaClinica, String specie, int lunghezza, int larghezza, int peso, String luogo_ritrovamento, String matricola) throws SQLException {
            Medico_VeterinarioDAOImpl medicoVeterinarioDAO = new Medico_VeterinarioDAOImpl();
            medicoVeterinarioDAO.updateCartellaClinica(idCartellaClinica, specie, lunghezza, larghezza, peso, luogo_ritrovamento, matricola);
        }
        public void updateComponenti(String idComponenti, Date dataCompilazione, String descBecco, String descCollo, String descTesta, String descCoda, String descPinne, String descOcchi, String descNaso) throws SQLException {
            Medico_VeterinarioDAOImpl medicoVeterinarioDAO = new Medico_VeterinarioDAOImpl();
            medicoVeterinarioDAO.updateComponenti(idComponenti, dataCompilazione, descBecco, descCollo, descTesta, descCoda, descPinne, descOcchi, descNaso);
        }
        //Tecnico Laboratorio metodi
        public int countTartarugheCondizioneBeccoAnno(String condizione, int anno) throws SQLException {
            RicercatoreDAOImpl ricercatoreDAO = new RicercatoreDAOImpl();
            int value = ricercatoreDAO.countTartarugheCondizioneBeccoAnno(condizione, anno);
            return value;
        }
        public int countTartarugheCondizioneCodaAnno(String condizione, int anno) throws SQLException {
            RicercatoreDAOImpl ricercatoreDAO = new RicercatoreDAOImpl();
            int value = ricercatoreDAO.countTartarugheCondizioneCodaAnno(condizione, anno);
            return value;
        }
        public int countTartarugheCondizioneColloAnno(String condizione, int anno) throws SQLException {
            RicercatoreDAOImpl ricercatoreDAO = new RicercatoreDAOImpl();
            int value = ricercatoreDAO.countTartarugheCondizioneColloAnno(condizione, anno);
            return value;
        }
        public int countTartarugheCondizioneNasoAnno(String condizione, int anno) throws SQLException {
            RicercatoreDAOImpl ricercatoreDAO = new RicercatoreDAOImpl();
            int value = ricercatoreDAO.countTartarugheCondizioneNasoAnno(condizione, anno);
            return value;
        }
        public int countTartarugheCondizioneOcchiAnno(String condizione, int anno) throws SQLException {
            RicercatoreDAOImpl ricercatoreDAO = new RicercatoreDAOImpl();
            int value = ricercatoreDAO.countTartarugheCondizioneOcchiAnno(condizione, anno);
            return value;
        }
        public int countTartarugheCondizionePinneAnno(String condizione, int anno) throws SQLException {
            RicercatoreDAOImpl ricercatoreDAO = new RicercatoreDAOImpl();
            int value = ricercatoreDAO.countTartarugheCondizionePinneAnno(condizione, anno);
            return value;
        }
        public int countTartarugheCondizioneTestaAnno(String condizione, int anno) throws SQLException {
            RicercatoreDAOImpl ricercatoreDAO = new RicercatoreDAOImpl();
            int value = ricercatoreDAO.countTartarugheCondizioneTestaAnno(condizione, anno);
            return value;
        }
        public int countTartarugheCondizioneBeccoMese(String condizione, int mese, int anno) throws SQLException {
            RicercatoreDAOImpl ricercatoreDAO = new RicercatoreDAOImpl();
            int value = ricercatoreDAO.countTartarugheCondizioneBeccoMese(condizione, mese, anno);
            return value;
        }
        public int countTartarugheCondizioneCodaMese(String condizione, int mese, int anno) throws SQLException {
            RicercatoreDAOImpl ricercatoreDAO = new RicercatoreDAOImpl();
            int value = ricercatoreDAO.countTartarugheCondizioneCodaMese(condizione, mese, anno);
            return value;
        }
        public int countTartarugheCondizioneColloMese(String condizione, int mese, int anno) throws SQLException {
            RicercatoreDAOImpl ricercatoreDAO = new RicercatoreDAOImpl();
            int value = ricercatoreDAO.countTartarugheCondizioneColloMese(condizione, mese, anno);
            return value;
        }
        public int countTartarugheCondizioneNasoMese(String condizione, int mese, int anno) throws SQLException {
            RicercatoreDAOImpl ricercatoreDAO = new RicercatoreDAOImpl();
            int value = ricercatoreDAO.countTartarugheCondizioneNasoMese(condizione, mese, anno);
            return value;
        }
        public int countTartarugheCondizioneOcchiMese(String condizione, int mese, int anno) throws SQLException {
            RicercatoreDAOImpl ricercatoreDAO = new RicercatoreDAOImpl();
            int value = ricercatoreDAO.countTartarugheCondizioneOcchiMese(condizione, mese, anno);
            return value;
        }
        public int countTartarugheCondizionePinneMese(String condizione, int mese, int anno) throws SQLException {
            RicercatoreDAOImpl ricercatoreDAO = new RicercatoreDAOImpl();
            int value = ricercatoreDAO.countTartarugheCondizionePinneMese(condizione, mese, anno);
            return value;
        }
        public int countTartarugheCondizioneTestaMese(String condizione, int mese, int anno) throws SQLException {
            RicercatoreDAOImpl ricercatoreDAO = new RicercatoreDAOImpl();
            int value = ricercatoreDAO.countTartarugheCondizioneTestaMese(condizione, mese, anno);
            return value;
        }
        //metodi cartella clinica e componenti
        public ArrayList<Cartella_Clinica> getCartelleCliniche() throws SQLException {
            Cartella_ClinicaDAOImpl cartellaClinicaDAO = new Cartella_ClinicaDAOImpl();
            return cartellaClinicaDAO.getCartelleCliniche();
        }
        public ArrayList<Componenti> getComponenti() throws SQLException{
            ComponentiDAOImpl ComponentiDAO = new ComponentiDAOImpl();
            return ComponentiDAO.getComponenti();
        }

    }
