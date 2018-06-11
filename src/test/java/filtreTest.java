import fr.utbm.lo54.entity.Course;
import fr.utbm.lo54.entity.CourseSession;
import fr.utbm.lo54.entity.Location;
import fr.utbm.lo54.repository.HibernateDao;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.h2.tools.RunScript;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.CoreMatchers.is;


public class filtreTest  {

List<CourseSession> expected= new ArrayList<>();
String date="2018-05-01";
    Date startDate = null;
   // startDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime());
Location lo = new Location(1,"BELFORT");
Course co = new Course("1","Programmation JAVA");
CourseSession cs = new CourseSession(1,null,null,45,lo, co);



    private IDataSet readDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new File("src/test/resources/dbUnit.xml"));
    }

    private void cleanlyInsertDataset(IDataSet dataSet) throws Exception {
        IDatabaseTester databaseTester = new JdbcDatabaseTester(
                "org.h2.Driver", "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "sa", "");
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }

    @Before
    public void importDataSet() throws Exception {
        IDataSet dataSet = readDataSet();
        cleanlyInsertDataset(dataSet);
    }

    @BeforeClass
    public static void createSchema() throws Exception {
        RunScript.execute("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1",
                "sa", "", "src/test/resources/shema.sql", UTF_8, false);
    }

    @Test
    public void findCourseTest() throws Exception {
        HibernateDao repository = new HibernateDao();
        List<Object[]> listSession = repository.filtreCourse("1","");
      Object[] test;
        test=listSession.get(0);
        //ts=listSession.get(1);
        String var= (String) test[0];


        assertThat(var, is("1"));
       // assertThat(test.getId().getCity(), is("BELFORT"));
      //  assertThat(test.getCode().getCode(), is("Programmation JAVA"));

    }

   /* @Test
    public void returnsNullWhenPersonCannotBeFoundByFirstName() throws Exception {
        PersonRepository repository = new PersonRepository(dataSource());
        Person person = repository.findPersonByFirstName("iDoNotExist");

        assertThat(person, is(nullValue()));
    }*/

}
