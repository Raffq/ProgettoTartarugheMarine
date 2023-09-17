package DAO.Tartaruga;

import ClassiPrincipali.Tartaruga;
import DAO.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TartarugaDAOImpl implements TartarugaDAO {
    public Tartaruga get(String id) throws SQLException {
        Connection con = Database.getConnection();
        Tartaruga tartaruga = null;
        try {
            String sql = "Select * From tartaruga Where targhetta = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                String targhetta = resultSet.getString("targhetta");
                String nome = resultSet.getString("nometartaruga");
                Boolean presentenelcentro = resultSet.getBoolean("presentenelcentro");
                String fkidvasca = resultSet.getString("fkidvasca");
                String fkidcentro = resultSet.getString("fkidcentro");

                tartaruga = new Tartaruga(targhetta, nome, presentenelcentro, fkidcentro, fkidvasca);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
        return tartaruga;
    }

    @Override
    public List<Tartaruga> getTartarugheNelCentro(String idCen, boolean presenteNelCentro) throws SQLException {
        Connection con = Database.getConnection();
        ArrayList<Tartaruga> tartarughe= new ArrayList();

        try {
            String sql = "CALL cursorOfTartarugheNelCentro(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, idCen);
            ps.setBoolean(2, presenteNelCentro);

            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                String targhetta = resultSet.getString("targhetta");
                String nome = resultSet.getString("nometartaruga");
                Boolean presentenelcentro = resultSet.getBoolean("presentenelcentro");
                String fkidvasca = resultSet.getString("fkidvasca");
                String fkidcentro = resultSet.getString("fkidcentro");

                Tartaruga tartaruga = new Tartaruga(targhetta, nome, presentenelcentro, fkidcentro, fkidvasca);
                tartarughe.add(tartaruga);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
        return tartarughe;
    }
}
