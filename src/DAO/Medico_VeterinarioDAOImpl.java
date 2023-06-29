package DAO;

import ClassiPrincipali.Medico_Veterinario;
import java.sql.*;
import java.util.List;

public class Medico_VeterinarioDAOImpl implements Medico_VeterinarioDAO {

    @Override
    public Medico_Veterinario get(String id) throws SQLException {
        Connection con = Database.getConnection();
        Medico_Veterinario medico_veterinario = null;

        String sql = "Select * From medico_veterinario Where matricolamv = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, id);

    }
}
