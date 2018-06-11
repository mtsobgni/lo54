package fr.utbm.lo54.service;

import fr.utbm.lo54.entity.Course;
import fr.utbm.lo54.repository.CourseDao;

import java.util.List;

public class CourseService {

    public Course getCourse(String code) {
        CourseDao courseDao = new CourseDao();
        Course course = courseDao.getCourse(code);
        return course;
    }

    public List<Course> listAllCourses() {
        CourseDao courseDao = new CourseDao();
        List<Course> listCourse = courseDao.getAllCourse();
        return listCourse;
    };

    public List<Course> listCourseByFilter(String keyWord, String locationId, String date) {
        CourseDao courseDao = new CourseDao();
        List<Course> listCourse = courseDao.getCourseByFilter(keyWord, locationId, date);
        return listCourse;
    }

}
