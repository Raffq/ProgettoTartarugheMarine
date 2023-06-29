package DAO;

import ClassiPrincipali.Medico_Veterinario;
import ClassiPrincipali.Ricercatore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RicercatoreDAOImpl implements RicercatoreDAO{
    @Override
    public Ricercatore get(String id) throws SQLException {
        Connection con = Database.getConnection();
        Ricercatore ricercatore = null;

        String sql = "Select * From ricercatore Where matricolarc = ?"; //TODO: cambiare nel database il nome da matricolaric a matricolarc
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, id);
        ResultSet resultSet = ps.executeQuery();
        try {
            if (resultSet.next()) {
                String matricola = resultSet.getString("matricolarc");
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
