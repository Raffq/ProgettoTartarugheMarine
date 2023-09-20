package DAO.Ricercatore;

import ClassiPrincipali.Ricercatore;
import DAO.Database;
import DAO.Ricercatore.RicercatoreDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RicercatoreDAOImpl implements RicercatoreDAO {
    @Override
    public Ricercatore get(String id) throws SQLException {
        Connection con = Database.getConnection();
        Ricercatore ricercatore = null;
        try{
        String sql = "Select * From ricercatore Where matricolaric = ?"; //TODO: cambiare nel database il nome da matricolaric a matricolarc
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, id);
        ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                String matricola = resultSet.getString("matricolaric");
                String nome = resultSet.getString("nome");
                String cognome = resultSet.getString("cognome");
                String fkidcentro = resultSet.getString("fkidcentro");

                ricercatore = new Ricercatore(matricola, nome, cognome, fkidcentro);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
        return ricercatore;
    }

}
