package DAO.Tartaruga;

import ClassiPrincipali.Tartaruga;
import DAO.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface TartarugaDAO extends DAO<Tartaruga> {
    public ArrayList<Tartaruga> getTartarugheNelCentro(String idCen, boolean presenteNelCentro) throws SQLException;
}
