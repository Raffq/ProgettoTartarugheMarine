package DAO.Cartella_Clinica;

import ClassiPrincipali.Cartella_Clinica;
import DAO.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Cartella_ClinicaDAO extends DAO<Cartella_Clinica> {
    public ArrayList<Cartella_Clinica> getCartelleCliniche() throws SQLException;
}
