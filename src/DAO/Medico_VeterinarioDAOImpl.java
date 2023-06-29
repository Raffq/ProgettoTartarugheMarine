package DAO;

import ClassiPrincipali.Medico_Veterinario;
import java.sql.*;

public class Medico_VeterinarioDAOImpl implements Medico_VeterinarioDAO {

    @Override
    public Medico_Veterinario get(int id) throws SQLException {
        Connection con = Database.getConnection();
        Medico_Veterinario medico_veterinario = null;

        String sql = "Select "
        return null;
    }
}
