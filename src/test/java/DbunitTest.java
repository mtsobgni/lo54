import fr.utbm.lo54.entity.Location;
import fr.utbm.lo54.service.ListeFormation;
import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.database.search.TablesDependencyHelper;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DbunitTest extends DBTestCase {

    public DbunitTest() {
    }

    public DbunitTest(String name) {
        super(name);

        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "org.postgresql.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:postgresql://localhost:5432/Formation");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "postgres");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "Lecombattant1");
        // System.setProperty (PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA, "");
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder(). build (new FileInputStream("src/test/resources/dbUnit.xml"));
    }

    protected DatabaseOperation getSetUpOperation () throws Exception
    {
        return DatabaseOperation.REFRESH;
    }

    protected DatabaseOperation getTearDownOperation () throws Exception
    {
        return DatabaseOperation.NONE;
    }

    /**
             Méthode de remplacement pour définir des propriétés / fonctionnalités personnalisées
      **/
    protected void setUpDatabaseConfig(DatabaseConfig config) {
        config.setProperty(DatabaseConfig.PROPERTY_BATCH_SIZE, new Integer(97));
        config.setFeature(DatabaseConfig.FEATURE_BATCHED_STATEMENTS, true);
    }
@Test
public void testRead() throws Exception {
    List<Location> list;
    ListeFormation lst = new ListeFormation();
    list=lst.listLocation();
    IDataSet expds = new FlatXmlDataSetBuilder().build(new FileInputStream("src/test/resources/dbUnit.xml"));
    ITable expectedTable = expds.getTable("location");
    IDatabaseConnection connection = getConnection();
    IDataSet databaseDataSet = connection.createDataSet();
    ITable actualTable = databaseDataSet.getTable("location");
    Assertion.assertEquals(expectedTable, actualTable);
}


        public void importExport () {
            Connection con= null;
            try {
                Class.forName("org.postgresql.Driver").newInstance();
                String dbURL = "jdbc:postgresql://localhost:5432/Formation";
                String user = "postgres";
                String pass = "Lecombattant1";
                con = DriverManager.getConnection(dbURL, user, pass);
                System.out.println("Connexion OK");

                IDatabaseConnection connection = new DatabaseConnection(con);

                // partial database export
            /*    QueryDataSet partialDataSet = new QueryDataSet(connection);
                partialDataSet.addTable("FOO", "SELECT * FROM TABLE WHERE COL='VALUE'");
                partialDataSet.addTable("BAR");
                FlatXmlDataSet.write(partialDataSet, new FileOutputStream("partial.xml"));*/

                // full database export
                IDataSet fullDataSet = connection.createDataSet();
                FlatXmlDataSet.write(fullDataSet, new FileOutputStream("src/test/resources/dbUnit.xml"));

                // dependent tables database export: export table X and all tables that
                // have a PK which is a FK on X, in the right order for insertion
             /*   String[] depTableNames =
                        TablesDependencyHelper.getAllDependentTables( connection, "X" );
                IDataSet depDataSet = connection.createDataSet( depTableNames );
                FlatXmlDataSet.write(depDataSet, new FileOutputStream("dependents.xml"));*/



                connection.close();



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
