package fr.utbm.lo54.repository;

import fr.utbm.lo54.entity.Course;
import fr.utbm.lo54.entity.CourseSession;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.h2.tools.RunScript;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class CourseDaoTest {

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
    public void getCourseByFilterTest() throws Exception {

        String keyWord= "Progra";
        String locationId ="1";
        String date =  "2018-05-01";
        List<Course> listCourseExpect;
        String expected ;

        CourseDao courseDao = new CourseDao();
        listCourseExpect=courseDao.getCourseByFilter(keyWord,locationId,date);
        expected=listCourseExpect.get(0).getCode();
        Assert.assertEquals(expected, ("1"));


    }



    @Test
    public void returnsNullWhenCourseCannotBeFoundByFilterTest() throws Exception {

        String keyWord= "Progra";
        String locationId ="2";
        String date =  "2018-05-01";
        List<Course> listCourseExpect;
        String expected ;

        ArrayList<Course> actualListCourse= new ArrayList<Course>();

        CourseDao courseDao = new CourseDao();
        listCourseExpect=courseDao.getCourseByFilter(keyWord,locationId,date);
        // expected=listExpect.get(0).getIdSession();
        Assert.assertEquals(listCourseExpect, actualListCourse);
    }


    @Test
    public void getCourseTest() throws Exception {

        String idCourse= "1";
        Course CourseExpect;
        String expected ;
        Course actualCourse = new Course("1","Programmation JAVA");

        CourseDao courseDao = new CourseDao();
        CourseExpect=courseDao.getCourse(idCourse);
        expected=CourseExpect.getCode();
        Assert.assertEquals(CourseExpect, actualCourse);


    }

  /*  @Test
    public void returnsNullWhenCourseCannotBeFoundByCodeTest() throws Exception {

        String idCourse= "89";
        Course CourseExpect;
        String expected ;
        Course actualCourse = new Course("89","Programmation JAVA");

        CourseDao courseDao = new CourseDao();
        CourseExpect=courseDao.getCourse(idCourse);
        //expected=CourseExpect.getCode();
        Assert.assertEquals(CourseExpect, actualCourse);


    }*/


}



