package main;

import fr.utbm.lo54.entity.CourseSession;
import fr.utbm.lo54.service.CourseSessionService;
import fr.utbm.lo54.tools.Helper;

import java.text.ParseException;

public class App1 {

    public static void main(String[] args) throws ParseException {
        CourseSessionService courseSessionService = new CourseSessionService();
        CourseSession courseSession = courseSessionService.getCourseSession(1);
        System.out.println(Helper.formatFrenchDate(courseSession.getStartDate()));
    }
}

