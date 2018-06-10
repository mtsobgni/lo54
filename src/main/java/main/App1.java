package main;

import fr.utbm.lo54.service.ClientService;

import java.text.ParseException;

public class App1 {

    public static void main(String[] args) throws ParseException {
//        CourseSessionService courseSessionService = new CourseSessionService();
//        CourseSession courseSession = courseSessionService.getCourseSession(1);
//        System.out.println(Helper.formatFrenchDate(courseSession.getStartDate()));

        ClientService clientService = new ClientService();
        System.out.println(clientService.getNumClient(1));

    }
}

