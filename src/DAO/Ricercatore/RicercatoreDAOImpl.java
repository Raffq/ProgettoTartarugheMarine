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
    @Override
    public int countTartarugheCondizioneBeccoAnno(String condizione, int anno) throws SQLException {
        Connection con = Database.getConnection();
        int statistica = 0;
        try {
            String sql = "Select countTartarugheCondizioneBeccoAnno(?::condizione, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, condizione);
            ps.setInt(2, anno);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                statistica = resultSet.getInt("countTartarugheCondizioneBeccoAnno");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return statistica;
    }

    @Override
    public int countTartarugheCondizioneCodaAnno(String condizione, int anno) throws SQLException {
        Connection con = Database.getConnection();
        int statistica = 0;
        try {
            String sql = "Select countTartarugheCondizioneCodaAnno(?::condizione, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, condizione);
            ps.setInt(2, anno);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                statistica = resultSet.getInt("countTartarugheCondizioneCodaAnno");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return statistica;
    }

    @Override
    public int countTartarugheCondizioneColloAnno(String condizione, int anno) throws SQLException {
        Connection con = Database.getConnection();
        int statistica = 0;
        try {
            String sql = "Select countTartarugheCondizioneColloAnno(?::condizione, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, condizione);
            ps.setInt(2, anno);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                statistica = resultSet.getInt("countTartarugheCondizioneColloAnno");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return statistica;
    }

    @Override
    public int countTartarugheCondizioneNasoAnno(String condizione, int anno) throws SQLException {
        Connection con = Database.getConnection();
        int statistica = 0;
        try {
            String sql = "Select countTartarugheCondizioneNasoAnno(?::condizione, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, condizione);
            ps.setInt(2, anno);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                statistica = resultSet.getInt("countTartarugheCondizioneNasoAnno");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return statistica;
    }

    @Override
    public int countTartarugheCondizioneOcchiAnno(String condizione, int anno) throws SQLException {
        Connection con = Database.getConnection();
        int statistica = 0;
        try {
            String sql = "Select countTartarugheCondizioneOcchiAnno(?::condizione, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, condizione);
            ps.setInt(2, anno);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                statistica = resultSet.getInt("countTartarugheCondizioneOcchiAnno");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return statistica;
    }

    @Override
    public int countTartarugheCondizionePinneAnno(String condizione, int anno) throws SQLException {
        Connection con = Database.getConnection();
        int statistica = 0;
        try {
            String sql = "Select countTartarugheCondizionePinneAnno(?::condizione, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, condizione);
            ps.setInt(2, anno);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                statistica = resultSet.getInt("countTartarugheCondizionePinneAnno");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return statistica;
    }

    @Override
    public int countTartarugheCondizioneTestaAnno(String condizione, int anno) throws SQLException {
        Connection con = Database.getConnection();
        int statistica = 0;
        try {
            String sql = "Select countTartarugheCondizioneTestaAnno(?::condizione, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, condizione);
            ps.setInt(2, anno);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                statistica = resultSet.getInt("countTartarugheCondizioneTestaAnno");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return statistica;
    }

    @Override
    public int countTartarugheCondizioneBeccoMese(String condizione, int mese, int anno) throws SQLException {
        Connection con = Database.getConnection();
        int statistica = 0;
        try {
            String sql = "Select countTartarugheCondizioneBeccoMese(?::condizione, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, condizione);
            ps.setInt(2, mese);
            ps.setInt(3, anno);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                statistica = resultSet.getInt("countTartarugheCondizioneBeccoMese");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return statistica;
    }

    @Override
    public int countTartarugheCondizioneCodaMese(String condizione, int mese, int anno) throws SQLException {
        Connection con = Database.getConnection();
        int statistica = 0;
        try {
            String sql = "Select countTartarugheCondizioneCodaMese(?::condizione, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, condizione);
            ps.setInt(2, mese);
            ps.setInt(3, anno);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                statistica = resultSet.getInt("countTartarugheCondizioneCodaMese");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return statistica;
    }

    @Override
    public int countTartarugheCondizioneColloMese(String condizione, int mese, int anno) throws SQLException {
        Connection con = Database.getConnection();
        int statistica = 0;
        try {
            String sql = "Select countTartarugheCondizioneColloMese(?::condizione, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, condizione);
            ps.setInt(2, mese);
            ps.setInt(3, anno);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                statistica = resultSet.getInt("countTartarugheCondizioneColloMese");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return statistica;
    }

    @Override
    public int countTartarugheCondizioneNasoMese(String condizione, int mese, int anno) throws SQLException {
        Connection con = Database.getConnection();
        int statistica = 0;
        try {
            String sql = "Select countTartarugheCondizioneNasoMese(?::condizione, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, condizione);
            ps.setInt(2, mese);
            ps.setInt(3, anno);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                statistica = resultSet.getInt("countTartarugheCondizioneNasoMese");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return statistica;
    }

    @Override
    public int countTartarugheCondizioneOcchiMese(String condizione, int mese, int anno) throws SQLException {
        Connection con = Database.getConnection();
        int statistica = 0;
        try {
            String sql = "Select countTartarugheCondizioneOcchiMese(?::condizione, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, condizione);
            ps.setInt(2, mese);
            ps.setInt(3, anno);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                statistica = resultSet.getInt("countTartarugheCondizioneOcchiMese");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return statistica;
    }

    @Override
    public int countTartarugheCondizionePinneMese(String condizione, int mese, int anno) throws SQLException {
        Connection con = Database.getConnection();
        int statistica = 0;
        try {
            String sql = "Select countTartarugheCondizionePinneMese(?::condizione, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, condizione);
            ps.setInt(2, mese);
            ps.setInt(3, anno);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                statistica = resultSet.getInt("countTartarugheCondizionePinneMese");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return statistica;
    }

    @Override
    public int countTartarugheCondizioneTestaMese(String condizione, int mese, int anno) throws SQLException {
        Connection con = Database.getConnection();
        int statistica = 0;
        try {
            String sql = "Select countTartarugheCondizioneTestaMese(?::condizione, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, condizione);
            ps.setInt(2, mese);
            ps.setInt(3, anno);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                statistica = resultSet.getInt("countTartarugheCondizioneTestaMese");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return statistica;
    }

}
