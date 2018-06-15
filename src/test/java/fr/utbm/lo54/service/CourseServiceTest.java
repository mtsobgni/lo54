package fr.utbm.lo54.service;

import fr.utbm.lo54.entity.Course;
import fr.utbm.lo54.repository.CourseDao;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.util.List;

import static org.mockito.Matchers.anyString;

public class CourseServiceTest {
    // Mock du DAO
    @Mock
    private CourseDao courseDao;
    List<Course> listCourseDaoActual = null;
    // Classe à Tester
    private CourseService courseService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        courseService = new CourseService(courseDao);
    }

    @Test
    public void getCourseByFilterTest() throws ParseException {
        String keyWord = "Java";
        String locationId = "Belfort";
        String date = "";

        BDDMockito.given(courseDao.getCourseByFilter(anyString(), anyString(), anyString())).willReturn(listCourseDaoActual);

        List<Course> expectedListCourse = courseService.listCourseByFilter(keyWord, locationId, date);

        Assertions.assertThat(expectedListCourse).isEqualTo(listCourseDaoActual);
    }

}





