package main;

import fr.utbm.lo54.entity.Course;
import fr.utbm.lo54.entity.Location;
import fr.utbm.lo54.repository.CourseDao;
import fr.utbm.lo54.service.ClientService;

import java.text.ParseException;
import java.util.List;
import java.util.ListIterator;

public class App1 {

    public static void main(String[] args) throws ParseException {
//        CourseSessionService courseSessionService = new CourseSessionService();
//        CourseSession courseSession = courseSessionService.getCourseSession(1);
//        System.out.println(Helper.formatFrenchDate(courseSession.getStartDate()));
        List<Course> listTest;
        ClientService clientService = new ClientService();
        CourseDao test = new CourseDao();
        listTest=test.getCourseByFilter("Pro","1","");
        ListIterator<Course> itrLocation = listTest.listIterator();
        while (itrLocation.hasNext()) {
            System.out.println(itrLocation.next().getTitle());
        }



       // System.out.println(clientService.getNumClient(1));

    }
}

