import junit.framework.TestCase;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;

public class TestDbUnit extends TestCase {

    public TestDbUnit() {
    }

    public TestDbUnit(String name) {
        super(name);
    }

     protected void setUp () throws Exception
    {
        super.setUp ();

        // initialise ta connexion à la base de données ici
        IDatabaseConnection connection = null;
        // ...

        // initialise ton ensemble de données ici
        IDataSet dataSet = null;
        // ...

        try
        {
            DatabaseOperation.CLEAN_INSERT.execute (connection, dataSet);
        }
        finally
        {
            connection.close ();
        }
    }

    /*public class EmployeeSampleTest extends TestCase {

public EmployeeSampleTest(String name)
{
super(name);
}
IDatabaseTester databaseTester;

public void setUp() throws Exception{
databaseTester = new JdbcDatabaseTester("com.mysql.jdbc.Driver","jdbc:mysql://localhost/test","root", "vampire");
IDataSet dataSet = new FlatXmlDataSetBuilder().build(new FileInputStream("customer- init.xml"));
databaseTester.setDataSet(dataSet); databaseTester.onSetup();                                                       }

public void testInsert() {
//your test method here
}

public void tearDown() throws Exception {
databaseTester.onTearDown();
}
}*/
}
