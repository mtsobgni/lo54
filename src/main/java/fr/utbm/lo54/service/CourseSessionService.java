package fr.utbm.lo54.service;

import fr.utbm.lo54.entity.CourseSession;
import fr.utbm.lo54.repository.CourseSessionDao;

import java.util.List;

public class CourseSessionService {

    public CourseSession getCourseSession(int id) {
        CourseSessionDao courseSessionDao = new CourseSessionDao();
        CourseSession courseSession = courseSessionDao.getCourseSession(id);
        return courseSession;
    }

    public List<CourseSession> listAllCourseSessions() {
        CourseSessionDao courseSessionDao = new CourseSessionDao();
        List<CourseSession> listCourseSession = courseSessionDao.getAllCourseSessions();
        return listCourseSession;
    }

    public List<CourseSession> listCourseByFilter(String keyWord, String locationId, String date) {
        CourseSessionDao courseSessionDao = new CourseSessionDao();
        List<CourseSession> listCourseSession = courseSessionDao.getCourseSessionByFilter(keyWord, locationId, date);
        return listCourseSession;
    }

}
