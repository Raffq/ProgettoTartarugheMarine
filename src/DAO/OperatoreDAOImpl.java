package DAO;

import ClassiPrincipali.Operatore;
import java.sql.*;
import java.util.List;

public class OperatoreDAOImpl implements OperatoreDAO {

    @Override
    public Operatore get(String id) throws SQLException {
        Connection con = Database.getConnection();
        Operatore operatore = null;
        try {
            String sql = "Select * From operatore Where matricolaop = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String matricolaop = rs.getString("matricolaop");
                String nome = rs.getString("nome");
                String cognome = rs.getString("cognome");
                String fkidcentro = rs.getString("fkidcentro");

                operatore = new Operatore(matricolaop, nome, cognome, fkidcentro);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
        return operatore;
    }
}