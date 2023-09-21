package DAO.Medico_Veterinario;

import ClassiPrincipali.Medico_Veterinario;
import DAO.DAO;

import java.sql.Date;
import java.sql.SQLException;

public interface Medico_VeterinarioDAO extends DAO<Medico_Veterinario> {
    public void compileLastCartellaClinica(String idTartaruga, String specie, int lunghezza, int larghezza, int peso, String luogo_ritrovamento, String matricola) throws SQLException;
    public void compileComponenti(String idTartaruga, Date dataCompilazione, String descBecco, String descCollo, String descTesta, String descCoda, String descPinne, String descOcchi, String descNaso) throws SQLException;
    public void updateCartellaClinica(String idCartellaClinica, String specie, int lunghezza, int larghezza, int peso, String luogo_ritrovamento, String matricola) throws SQLException;
    public void updateComponenti(String idComponenti, Date dataCompilazione, String descBecco, String descCollo, String descTesta, String descCoda, String descPinne, String descOcchi, String descNaso) throws SQLException;
}
