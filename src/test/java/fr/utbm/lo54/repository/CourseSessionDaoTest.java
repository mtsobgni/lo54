package fr.utbm.lo54.repository;

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

public class CourseSessionDaoTest {

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
    public void getCourseSessionsByCodeTest() throws Exception {

        String code= "1";
        List<CourseSession> listExpect;
        int expected ;

       CourseSessionDao courseSessionDao = new CourseSessionDao();
       listExpect=courseSessionDao.getCourseSessionsByCode(code);
       expected=listExpect.get(0).getIdSession();
        Assert.assertEquals(expected, (1));


    }



    @Test
    public void returnsNullWhenCourseSessionCannotBeFoundByCodeTest() throws Exception {

        String code= "4857";
        List<CourseSession> listExpect;
        int expected ;
        ArrayList<CourseSession> actualListCourseSession= new ArrayList<CourseSession>();

        CourseSessionDao courseSessionDao = new CourseSessionDao();
        listExpect=courseSessionDao.getCourseSessionsByCode(code);
        Assert.assertEquals(listExpect, actualListCourseSession);


    }

    @Test
    public void getCourseSessionByIdTest() throws Exception {

        int idSession= 1;
        CourseSession expectSession;
        int expectedIdSession ;
        String expectedIdCourse ;
        int expectedIdLocation ;

        CourseSessionDao courseSessionDao = new CourseSessionDao();
        expectSession=courseSessionDao.getCourseSession(idSession);
        expectedIdSession=expectSession.getIdSession();
        expectedIdCourse=expectSession.getCode().getCode();
        expectedIdLocation=expectSession.getId().getId();
        Assert.assertEquals(expectedIdSession, (1));
        Assert.assertEquals(expectedIdCourse, "1");
        Assert.assertEquals(expectedIdLocation, (1));


    }

   /* @Test
    public void returnsNullWhenCourseSessionCannotBeFoundByIdTest() throws Exception {

        int idSession= 857;
        CourseSession expectedSession;
        CourseSession actualCourseSession= new CourseSession();

        CourseSessionDao courseSessionDao = new CourseSessionDao();
        expectedSession=courseSessionDao.getCourseSession(idSession);
        Assert.assertEquals(expectedSession, null);


    }*/


}




