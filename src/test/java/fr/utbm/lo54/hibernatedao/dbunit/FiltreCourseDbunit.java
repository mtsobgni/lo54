package fr.utbm.lo54.hibernatedao.dbunit;

import fr.utbm.lo54.repository.HibernateDao;
import fr.utbm.lo54.service.ListeFormation;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertThat;

import javax.sql.DataSource;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hamcrest.core.Is.is;


public class FiltreCourseDbunit {


    private static final String JDBC_DRIVER = org.h2.Driver.class.getName();
    private static final String JDBC_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    @BeforeClass
    public static void createSchema() throws Exception {
        RunScript.execute(JDBC_URL, USER, PASSWORD, "src/test/resources/shema.sql", UTF_8, false);
    }

    @Before
    public void importDataSet() throws Exception {
        IDataSet dataSet = readDataSet();
        cleanlyInsert(dataSet);
    }

    private IDataSet readDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new File("src/test/resources/dbUnit.xml"));
    }

    private void cleanlyInsert(IDataSet dataSet) throws Exception {
        IDatabaseTester databaseTester = new JdbcDatabaseTester(JDBC_DRIVER, JDBC_URL, USER, PASSWORD);
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }

    @Test
    public void filterCourseSessionByCodeAndLoacation() throws Exception {



        Object[] val1 = new Object[]{"1","Programmation JAVA"};
        Object[] val2 = new Object[]{"2","2019-01-03"};
        Object[] val3 = new Object[]{"3","2018-10-11"};
        //ArrayList<Object[]> expected = new ArrayList<Object[]>((Collection<? extends Object[]>) Arrays.asList(val1));
//List<Object[]> expected= new List<Object[]>() {"1","Programmation"};
        HibernateDao repository = new HibernateDao();
        List<Object[]> listSession = repository.filtreCourse("Pro","");
        Object[] listSessionFiltre;

      /*  assertThat(charlie.getFirstName(), is("Charlie"));
        assertThat(charlie.getLastName(), is("Brown"));
        assertThat(charlie.getAge(), is(42));*/
    }

   /* @Test
    public void returnsNullWhenPersonCannotBeFoundByFirstName() throws Exception {
        PersonRepository repository = new PersonRepository(dataSource());
        Person person = repository.findPersonByFirstName("iDoNotExist");

        assertThat(person, is(nullValue()));
    }*/

    private DataSource dataSource() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL(JDBC_URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

}


