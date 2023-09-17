package DAO.Tartaruga;

import ClassiPrincipali.Tartaruga;
import DAO.*;

import java.sql.SQLException;
import java.util.List;

public interface TartarugaDAO extends DAO<Tartaruga> {
    public List<Tartaruga> getTartarugheNelCentro(String idCen, boolean presenteNelCentro) throws SQLException;
}
