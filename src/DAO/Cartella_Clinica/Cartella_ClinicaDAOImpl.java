package DAO.Cartella_Clinica;

import ClassiPrincipali.Cartella_Clinica;
import ClassiPrincipali.Componenti;
import ClassiPrincipali.Tartaruga;
import DAO.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Cartella_ClinicaDAOImpl implements Cartella_ClinicaDAO {

    @Override
    public Cartella_Clinica get(String id) throws SQLException {
        Connection con = Database.getConnection();
        Cartella_Clinica cartellaClinica = null;
        try {
            String sql = "Select * From cartella_clinica where idcartellaclinica = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String idCartellaClinica = rs.getString("idcartellaclinica");
                String specie = rs.getString("specie");
                int lunghezza = rs.getInt("lunghezza");
                int larghezza = rs.getInt("larghezza");
                int peso = rs.getInt("peso");
                String luogoRitrovamento = rs.getString("luogoritrovamento");
                Date dataAmmissione = rs.getDate("dataammissione");
                Date dataRilascio = rs.getDate("datarilascio");
                String fkMatricolamv = rs.getString("fkmatricolamv");
                String fkTarghetta = rs.getString("fktarghetta");

                cartellaClinica = new Cartella_Clinica(idCartellaClinica, specie, lunghezza, larghezza, peso, luogoRitrovamento, dataAmmissione, dataRilascio, fkMatricolamv, fkTarghetta);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
        return cartellaClinica;
    }

    public ArrayList<Cartella_Clinica> getCartelleCliniche() throws SQLException {
        Connection con = Database.getConnection();
        ArrayList<Cartella_Clinica> cartelleCliniche= new ArrayList();

        try {
            String sql = "SELECT * FROM Cartella_Clinica";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                String idcartellaclinica = resultSet.getString("idcartellaclinica");
                String specie = resultSet.getString("specie");
                int lunghezza = resultSet.getInt("lunghezza");
                int larghezza = resultSet.getInt("larghezza");
                int peso = resultSet.getInt("peso");
                String luogoRitrovamento = resultSet.getString("luogoritrovamento");
                Date dataAmmissione = resultSet.getDate("dataammissione");
                Date dataRilascio = resultSet.getDate("datarilascio");
                String fkmatricolamv = resultSet.getString("fkmatricolamv");
                String fktarghetta = resultSet.getString("fktarghetta");

                Cartella_Clinica cartellaClinica = new Cartella_Clinica(idcartellaclinica, specie, lunghezza, larghezza, peso, luogoRitrovamento, dataAmmissione, dataRilascio, fkmatricolamv, fktarghetta);
                cartelleCliniche.add(cartellaClinica);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cartelleCliniche;
    }
}

