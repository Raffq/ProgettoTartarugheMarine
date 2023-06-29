package DAO;

import ClassiPrincipali.Ricercatore;
import ClassiPrincipali.Tecnico_Laboratorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tecnico_LaboratorioDAOImpl implements Tecnico_LaboratorioDAO{
    @Override
    public Tecnico_Laboratorio get(String id) throws SQLException {
        Connection con = Database.getConnection();
        Tecnico_Laboratorio tecnico_laboratorio = null;
        try {
        String sql = "Select * From tecnico_laboratorio Where matricolatl = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, id);
        ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                String matricola = resultSet.getString("matricolarc");
                String nome = resultSet.getString("nome");
                String cognome = resultSet.getString("cognome");
                String fkidcentro = resultSet.getString("fkidcentro");

                tecnico_laboratorio = new Tecnico_Laboratorio(matricola, nome, cognome, fkidcentro);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
        return tecnico_laboratorio;
    }
}
