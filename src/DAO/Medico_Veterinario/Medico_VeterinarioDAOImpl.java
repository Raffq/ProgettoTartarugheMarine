package DAO.Medico_Veterinario;

import ClassiPrincipali.Medico_Veterinario;
import DAO.Database;
import DAO.Medico_Veterinario.Medico_VeterinarioDAO;

import java.sql.*;

public class Medico_VeterinarioDAOImpl implements Medico_VeterinarioDAO {

    @Override
    public Medico_Veterinario get(String id) throws SQLException {
        Connection con = Database.getConnection();
        Medico_Veterinario medico_veterinario = null;
        try {
            String sql = "Select * From medico_veterinario Where matricolamv = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String matricolamv = rs.getString("matricolamv");
                String nome = rs.getString("nome");
                String cognome = rs.getString("cognome");
                String fkidcentro=rs.getString("fkidcentro");

                medico_veterinario = new Medico_Veterinario(matricolamv, nome, cognome, fkidcentro);
             }
        }catch (SQLException e) {
                System.out.println("Qualcosa è andato storto!");
        }
        return medico_veterinario;
    }

    public void compileLastCartellaClinica(String idTartaruga, String specie, int lunghezza, int larghezza, int peso, String luogo_ritrovamento, String matricola) throws SQLException {
        try {
            Connection con = Database.getConnection();
            String sql = "CALL compileLastCartellaClinica(?, ?, ?, ?, ?, ?, ?)";

            CallableStatement cs = con.prepareCall(sql);

            cs.setString(1, idTartaruga);
            cs.setString(2, specie);
            cs.setInt(3, lunghezza);
            cs.setInt(4, larghezza);
            cs.setInt(5, peso);
            cs.setString(6, luogo_ritrovamento);
            cs.setString(7, matricola);

            cs.execute();

        } catch(SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
    }
    public void compileComponenti(String idTartaruga, Date dataCompilazione, String descBecco, String descCollo, String descTesta, String descCoda, String descPinne, String descOcchi, String descNaso) throws SQLException {
        try {
            Connection con = Database.getConnection();
            String sql = "CALL compilecomponenti(?, ?, ?::condizione, ?::condizione, ?::condizione, ?::condizione, ?::condizione, ?::condizione, ?::condizione)";

            CallableStatement cs = con.prepareCall(sql);

            cs.setString(1, idTartaruga);
            cs.setDate(2, dataCompilazione);
            cs.setString(3, descBecco);
            cs.setString(4, descCollo);
            cs.setString(5, descTesta);
            cs.setString(6, descCoda);
            cs.setString(7, descPinne);
            cs.setString(8, descOcchi);
            cs.setString(9, descNaso);

            cs.execute();

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateCartellaClinica(String idCartellaClinica, String specie, int lunghezza, int larghezza, int peso, String luogo_ritrovamento, String matricola) throws SQLException {
        try {
            Connection con = Database.getConnection();
            String sql = "CALL updateCartellaClinica(?, ?, ?, ?, ?, ?, ?)";

            CallableStatement cs = con.prepareCall(sql);

            cs.setString(1, idCartellaClinica);
            cs.setString(2, specie);
            cs.setInt(3, lunghezza);
            cs.setInt(4, larghezza);
            cs.setInt(5, peso);
            cs.setString(6, luogo_ritrovamento);
            cs.setString(7, matricola);

            cs.execute();

        } catch(SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
    }
    public void updateComponenti(String idComponenti, Date dataCompilazione, String descBecco, String descCollo, String descTesta, String descCoda, String descPinne, String descOcchi, String descNaso) throws SQLException {
        try {
            Connection con = Database.getConnection();
            String sql = "CALL updateComponenti(?, ?, ?, ?, ?, ?, ?, ?, ?)";

            CallableStatement cs = con.prepareCall(sql);

            cs.setString(1, idComponenti);
            cs.setDate(2, dataCompilazione);
            cs.setString(3, descBecco);
            cs.setString(4, descCoda);
            cs.setString(5, descCollo);
            cs.setString(6, descNaso);
            cs.setString(7, descOcchi);
            cs.setString(8, descPinne);
            cs.setString(9, descTesta);

            cs.execute();

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
