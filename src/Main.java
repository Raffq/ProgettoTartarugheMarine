import Controller.Controller;
import Gui.MainWindow.MainWindow;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        /*
        Controller controller=new Controller();
        ArrayList<Tartaruga> tartarughe = controller.getTartarugheNelCentro("CN-SMRLD", false);
        for (Tartaruga i: tartarughe) {
            System.out.println(i.getTarghetta());
        }
*/
        /*Tecnico_LaboratorioDAOImpl test = new Tecnico_LaboratorioDAOImpl();
        test.countTartarugheCondizioneBeccoAnno("compromesso", 2023);*/
        MainWindow window = new MainWindow(new Controller());
        //RiammettiTemp riammettiTemp=new RiammettiTemp();

        //prova
    }
}

    /*CREATE OR REPLACE PROCEDURE compilecomponenti(IdTar varchar(60), descbecco condizione,desccollo condizione,desctesta condizione,descpinne condizione,descocchi condizione,descnasco condizione, dataCompilazione date) AS
        $$
        BEGIN
        UPDATE Componenti
        SET DescrizioneBecco = descBecco,
        DescrizioneCollo = descCollo,
        DescrizioneTesta = descTesta,
        DescrizioneCoda = descCoda,
        DescrizionePinne = descPinne,
        DescrizioneOcchi = descOcchi,
        DescrizioneNaso = descNaso,
        dataCompilazione = dataCompilazione
        WHERE fkTarghetta = idTar;
        END;
        $$
        language plpgsql

     */
