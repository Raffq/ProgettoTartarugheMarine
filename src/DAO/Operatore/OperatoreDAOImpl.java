package DAO.Operatore;

import ClassiPrincipali.Operatore;
import DAO.Database;
import DAO.Operatore.OperatoreDAO;

import java.sql.*;


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

    @Override
    public void ammetti(String nome, String idCentro, Date data) throws SQLException {
        try {
            Connection con = Database.getConnection();
            String sql = "CALL ammetti(?, ?, ?)";

            CallableStatement cs = con.prepareCall(sql);

            cs.setString(1, nome);
            cs.setString(2, idCentro);
            cs.setDate(3, data);

            cs.execute();

        } catch(SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
    }

    public void riammetti(String IdTar, Date data) throws SQLException {
        try {
            Connection con = Database.getConnection();
            String sql = "CALL riammetti(?, ?)";

            CallableStatement cs = con.prepareCall(sql);

            cs.setString(1, IdTar);
            cs.setDate(2, data);

            cs.execute();

        } catch(SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
    }

    public void rilascia(String IdTar, Date data) throws SQLException {
        try {
            Connection con = Database.getConnection();
            String sql = "CALL rilascia(?, ?)";

            CallableStatement cs = con.prepareCall(sql);

            cs.setString(1, IdTar);
            cs.setDate(2, data);

            cs.execute();

        } catch(SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
    }

}