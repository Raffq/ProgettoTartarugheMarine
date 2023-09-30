package DAO.Componenti;

import ClassiPrincipali.Componenti;
import DAO.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ComponentiDAO extends DAO<Componenti> {
    public ArrayList<Componenti> getComponenti() throws SQLException;
}
