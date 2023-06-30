import ClassiPrincipali.*;
import DAO.*;
import java.sql.*;


import javax.naming.ldap.Control;
import java.sql.*;
public class Main {
    public static void main(String[] args) throws SQLException {
        Controller controller = new Controller();
        String MatricolaTemp="OP001";
        String str="2015-03-31";
        Date date=Date.valueOf(str);


        Personale personale = new Personale();
        personale=controller.controllaMatricola(MatricolaTemp);

        if (personale instanceof Operatore) {
            System.out.println("Successo");
        }

        controller.accedi(personale);



        OperatoreDAO operatoreDAO = new OperatoreDAOImpl();

        operatoreDAO.ammetti("Francesco", personale.getfkidcentro(), date);


    }
}