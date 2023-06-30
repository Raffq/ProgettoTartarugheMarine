package DAO.Vasca;

import ClassiPrincipali.Vasca;
import DAO.Database;
import DAO.Vasca.VascaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VascaDAOImpl implements VascaDAO {
    @Override
    public Vasca get(String id) throws SQLException {
        Connection con = Database.getConnection();
        Vasca vasca = null;
        try{
            String sql = "Select * From vasca Where idvasca = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                String idvasca = resultSet.getString("idvasca");
                int postioccupati = resultSet.getInt("postioccupati");
                String fkidcentro = resultSet.getString("fkidcentro");

                vasca = new Vasca(idvasca, postioccupati, fkidcentro);
                }
            } catch (
                SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
        return vasca;
    }
}
