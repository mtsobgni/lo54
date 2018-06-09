package fr.utbm.lo54.service;

import fr.utbm.lo54.entity.CourseSession;
import fr.utbm.lo54.repository.CourseSessionDao;

import java.util.List;

public class CourseSessionService {

    public List<CourseSession> listCourseByFilter(String keyWord, String locationId, String date) {
        List<CourseSession> listCourse = null;
        CourseSessionDao courseDao = new CourseSessionDao();
        listCourse = courseDao.getCourseSessionByFilter(keyWord, locationId, date);
        return listCourse;
    }

}
