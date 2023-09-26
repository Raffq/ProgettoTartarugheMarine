package DAO.Tecnico_Laboratorio;

import ClassiPrincipali.Tecnico_Laboratorio;
import DAO.DAO;

import java.sql.SQLException;

public interface Tecnico_LaboratorioDAO extends DAO<Tecnico_Laboratorio> {
    public int countTartarugheCondizioneBeccoAnno(String condizione, int anno) throws SQLException;
    public int countTartarugheCondizioneCodaAnno(String condizione, int anno) throws SQLException;
    public int countTartarugheCondizioneColloAnno(String condizione, int anno) throws SQLException;
    public int countTartarugheCondizioneNasoAnno(String condizione, int anno) throws SQLException;
    public int countTartarugheCondizioneOcchiAnno(String condizione, int anno) throws SQLException;
    public int countTartarugheCondizionePinneAnno(String condizione, int anno) throws SQLException;
    public int countTartarugheCondizioneTestaAnno(String condizione, int anno) throws SQLException;
    //
    public int countTartarugheCondizioneBeccoMese(String condizione, int mese, int anno) throws SQLException;
    public int countTartarugheCondizioneCodaMese(String condizione, int mese, int anno) throws SQLException;
    public int countTartarugheCondizioneColloMese(String condizione, int mese, int anno) throws SQLException;
    public int countTartarugheCondizioneNasoMese(String condizione, int mese, int anno) throws SQLException;
    public int countTartarugheCondizioneOcchiMese(String condizione, int mese, int anno) throws SQLException;
    public int countTartarugheCondizionePinneMese(String condizione, int mese, int anno) throws SQLException;
    public int countTartarugheCondizioneTestaMese(String condizione, int mese, int anno) throws SQLException;
}
