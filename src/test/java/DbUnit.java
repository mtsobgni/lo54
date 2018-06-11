import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;


public class DbUnit {

    public void dbuUnit(){

        Connection con= null;
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            String dbURL = "jdbc:postgresql://localhost:5432/Formation";
            String user = "postgres";
            String pass = "Lecombattant1";
            con = DriverManager.getConnection(dbURL, user, pass);
            System.out.println("Connexion OK");

            IDatabaseConnection dbUnitConnection = new DatabaseConnection(con);

            FlatXmlDataSetBuilder xmlDSBuilder = new FlatXmlDataSetBuilder();

// on indique qu'on ne tiendra pas compte de la casse pour les noms de tables présents dans le XML
            xmlDSBuilder.setCaseSensitiveTableNames(false);

            InputStream inputStreamXML = new FileInputStream("src/test/resources/dbUnit.xml");

// L'objet inputStreamXML est un objet de type java.io.InputStream contenant le XML du dataset
// La méthode build va retourner un objet FlatXmlDataSet qui implémente l'interface IDataSet
            IDataSet dataSet = xmlDSBuilder.build(inputStreamXML);

// L'objet dbUnitConnection est une connexion dbUnit de type IDatabaseConnection
// Ici on indique qu'on exécutera une insertion en écrasant le contenu existant des tables présentes dans le dataset
            DatabaseOperation.CLEAN_INSERT.execute(dbUnitConnection, dataSet);

                dbUnitConnection.close();



        }catch (Throwable e){
            System.out.println("Connexion KO");
            e.printStackTrace();
        }finally{
            try{
                if(con!=null) con.close();
            }catch (SQLException e){}

        }

    }
}
