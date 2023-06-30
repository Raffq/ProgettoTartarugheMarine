package DAO.Centro;

import ClassiPrincipali.Centro;
import DAO.Centro.CentroDAO;
import DAO.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CentroDAOImpl implements CentroDAO {
    @Override
    public Centro get(String id) throws SQLException {
        Connection con = Database.getConnection();
        Centro centro = null;
        try {
            String sql = "Select * From centro Where idcentro = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String idcentro = rs.getString("idcentro");
                String nomecentro = rs.getString("nomecentro");

                centro = new Centro(idcentro, nomecentro);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
        return centro;
    }
}
