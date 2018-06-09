package fr.utbm.lo54.service;

import fr.utbm.lo54.entity.Course;
import fr.utbm.lo54.repository.CourseDao;

import java.util.List;

public class CourseService {

    public CourseService() {

    };

    public List<Course> listAllCourse() {
        List<Course> listCourse = null;
        CourseDao courseDao = new CourseDao();
        listCourse = courseDao.getAllCourse();
        return listCourse;
    };

}
