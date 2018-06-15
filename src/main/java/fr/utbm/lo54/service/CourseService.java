package fr.utbm.lo54.service;

import fr.utbm.lo54.entity.Course;
import fr.utbm.lo54.repository.CourseDao;

import java.util.List;

public class CourseService {

    private CourseDao courseDao;

    public CourseService() {
        courseDao = new CourseDao();
    }

    public CourseService(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public Course getCourse(String code) {
        Course course = courseDao.getCourse(code);
        return course;
    }

    public List<Course> listAllCourses() {
        List<Course> listCourse = courseDao.getAllCourse();
        return listCourse;
    };

    public List<Course> listCourseByFilter(String keyWord, String locationId, String date) {
        List<Course> listCourse = courseDao.getCourseByFilter(keyWord, locationId, date);
        return listCourse;
    }

}
