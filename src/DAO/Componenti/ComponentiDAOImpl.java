package DAO.Componenti;

import ClassiPrincipali.Cartella_Clinica;
import ClassiPrincipali.Centro;
import ClassiPrincipali.Componenti;
import DAO.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ComponentiDAOImpl implements ComponentiDAO {
    @Override
    public Componenti get(String id) throws SQLException {
        Connection con = Database.getConnection();
        Componenti componenti = null;
        try {
            String sql = "Select * From componenti where idComponenti = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String idComponenti = rs.getString("idcomponenti");
                String condizioneBecco = rs.getString("condizionebecco");
                String condizioneCollo = rs.getString("condizionecollo");
                String condizioneTesta = rs.getString("condizionetesta");
                String condizioneCoda = rs.getString("condizionecoda");
                String condizionePinne = rs.getString("condizionepinne");
                String condizioneOcchi = rs.getString("condizioneocchi");
                String condizioneNaso = rs.getString("condizionenaso");
                Date dataCompilazione = rs.getDate("datacompilazione");
                String fkTarghetta = rs.getString("fktarghetta");
                String fkidCartellaClinica = rs.getString("fkidcartellaclinica");

                componenti = new Componenti(idComponenti, condizioneBecco, condizioneCollo, condizioneTesta, condizioneCoda,condizionePinne,condizioneOcchi,condizioneNaso, dataCompilazione, fkTarghetta, fkidCartellaClinica);
            }
        } catch (SQLException e) {
            System.out.println("Qualcosa è andato storto!");
        }
        return componenti;
    }

    public ArrayList<Componenti> getComponenti() throws SQLException {
        Connection con = Database.getConnection();
        ArrayList<Componenti> componenti= new ArrayList();

        try {
            String sql = "SELECT * FROM Componenti";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                String idcomponenti = resultSet.getString("idcomponenti");
                String condizioneBecco= resultSet.getString("condizionebecco");
                String condizioneCollo = resultSet.getString("condizionecollo");
                String condizioneTesta = resultSet.getString("condizionetesta");
                String condizioneCoda = resultSet.getString("condizionecoda");
                String condizionePinne = resultSet.getString("condizionepinne");
                String condizioneOcchi = resultSet.getString("condizioneocchi");
                String condizioneNaso = resultSet.getString("condizionenaso");
                Date dataCompilazione = resultSet.getDate("datacompilazione");
                String fkTarghetta = resultSet.getString("fktarghetta");
                String fkIdCartellaClinica = resultSet.getString("fkidcartellaclinica");

                System.out.println(condizioneBecco);

                Componenti componente = new Componenti(idcomponenti, condizioneBecco, condizioneCollo, condizioneTesta, condizioneCoda, condizionePinne, condizioneOcchi, condizioneNaso, dataCompilazione, fkTarghetta, fkIdCartellaClinica);
                componenti.add(componente);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return componenti;
    }
}
