package DAO;

import ClassiPrincipali.Personale;
import java.sql.*;

public class PersonaleDAOImpl implements  PersonaleDAO{

    @Override
    public Personale get(int id) throws SQLException {
        Connection con = Database.getConnection();

        return null;
    }
}
