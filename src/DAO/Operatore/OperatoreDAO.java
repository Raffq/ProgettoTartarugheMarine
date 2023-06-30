package DAO.Operatore;

import ClassiPrincipali.Operatore;
import DAO.DAO;

import java.sql.Date;
import java.sql.SQLException;

public interface OperatoreDAO extends DAO<Operatore> {
        void ammetti(String nome, String idCentro, Date data) throws SQLException;
        void riammetti(String IdTar, Date data) throws SQLException;
        void rilascia(String IdTar, Date data) throws SQLException;
}
