package main;

import fr.utbm.lo54.entity.Client;
import fr.utbm.lo54.entity.Course;
import fr.utbm.lo54.entity.CourseSession;
import fr.utbm.lo54.entity.Location;
import fr.utbm.lo54.repository.ClientDao;
import fr.utbm.lo54.repository.CourseDao;
import fr.utbm.lo54.repository.CourseSessionDao;
import fr.utbm.lo54.repository.LocationDao;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

// this class is used to add something to the database

public class Seed {

    public static void main(String[] args) {
//        addLocation();
        addClient();
//        addCourse();
//        addCourseSession();
    }

    // add some locations to the database
    private static void addLocation() {
        List<Location> listLocation = new LinkedList<Location>();
        LocationDao locationDao = new LocationDao();

        listLocation.add(new Location(1,"Belfort"));
        listLocation.add(new Location(2,"Sevenans"));
        listLocation.add(new Location(3,"Montbéliard"));

        ListIterator<Location> itrLocation = listLocation.listIterator();
        while (itrLocation.hasNext()) {
            Location location = itrLocation.next();
            locationDao.save(location);
            System.out.println(location.toString());
        }
    }


    // add some clients to the database
    private static void addClient() {
        List<Client> listClient = new LinkedList<Client>();
        ClientDao clientDao = new ClientDao();
        CourseSessionDao courseSessionDao = new CourseSessionDao();

        listClient.add(new Client("Wei", "Maxime", "1 rue Gastion Defferre",
                                    "600000001", "maxime.wei@utbm.fr", courseSessionDao.getCourseSession(1)));
        listClient.add(new Client("Liu", "Michel", "1 rue Gastion Defferre",
                                    "600000002", "michel.liu@utbm.fr", courseSessionDao.getCourseSession(1)));
        listClient.add(new Client("Gou", "Louis", "1 rue Gastion Defferre",
                                    "600000003", "louis.gou@utbm.fr", courseSessionDao.getCourseSession(1)));
        listClient.add(new Client("Theo", "Liang", "1 rue Gastion Defferre",
                                    "600000004", "liang.theo@utbm.fr", courseSessionDao.getCourseSession(2)));
        listClient.add(new Client("Du", "Pierre", "1 rue Gastion Defferre",
                                    "600000005", "pierre.du@utbm.fr", courseSessionDao.getCourseSession(2)));

        ListIterator<Client> itrClient = listClient.listIterator();
        while (itrClient.hasNext()) {
            Client client = itrClient.next();
            clientDao.save(client);
            System.out.println(client.toString());
        }
    }


    // add some courses to the database
    private static void addCourse() {
        List<Course> listCourse = new LinkedList<Course>();
        CourseDao courseDao = new CourseDao();

        listCourse.add(new Course("LO54", "Java Enterprise Applications Architectures and Development Frameworks"));
        listCourse.add(new Course("EV02", "Energy, Environment and Sustainable Development"));
        listCourse.add(new Course("GE08", "Contrôle de gestion"));
        listCourse.add(new Course("GL51", "Processus et qualité du logiciel"));
        listCourse.add(new Course("GL52", "Génie logiciel"));
        listCourse.add(new Course("TX52", "Projet de recherche"));
        listCourse.add(new Course("BD50", "Conception des bases de données"));
        listCourse.add(new Course("RE51", "Algorithmiques distribuées et protocoles"));
        listCourse.add(new Course("LE08", "Communication écrite en anglais"));
        listCourse.add(new Course("SQ40", "Statistiques pour l'ingénieur"));

        ListIterator<Course> itrCourse = listCourse.listIterator();
        while (itrCourse.hasNext()) {
            Course course = itrCourse.next();
            courseDao.save(course);
            System.out.println(course.toString());
        }
    }


    // add some course sessions to the database
    private static void addCourseSession() {
        List<CourseSession> listCourseSession = new LinkedList<CourseSession>();
        CourseSessionDao CourseSessionDao = new CourseSessionDao();
        LocationDao locationDao = new LocationDao();
        CourseDao courseDao = new CourseDao();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");

        try {
            listCourseSession.add(new CourseSession(1, new Date(dateFormat.parse("27-02-2018").getTime()),
                    new Date(dateFormat.parse("01-07-2018").getTime()), 30, locationDao.getLocation(1), courseDao.getCourse("LO54")));
            listCourseSession.add(new CourseSession(2, new Date(dateFormat.parse("27-02-2018").getTime()),
                    new Date(dateFormat.parse("01-07-2018").getTime()), 30, locationDao.getLocation(2), courseDao.getCourse("EV02")));
            listCourseSession.add(new CourseSession(3, new Date(dateFormat.parse("27-02-2018").getTime()),
                    new Date(dateFormat.parse("01-07-2018").getTime()), 30, locationDao.getLocation(3), courseDao.getCourse("GE08")));
            listCourseSession.add(new CourseSession(4, new Date(dateFormat.parse("27-02-2018").getTime()),
                    new Date(dateFormat.parse("01-07-2018").getTime()), 30, locationDao.getLocation(1), courseDao.getCourse("GL51")));
            listCourseSession.add(new CourseSession(5, new Date(dateFormat.parse("27-02-2018").getTime()),
                    new Date(dateFormat.parse("01-07-2018").getTime()), 30, locationDao.getLocation(2), courseDao.getCourse("GL52")));
            listCourseSession.add(new CourseSession(6, new Date(dateFormat.parse("27-02-2018").getTime()),
                    new Date(dateFormat.parse("01-07-2018").getTime()), 30, locationDao.getLocation(3), courseDao.getCourse("TX52")));
            listCourseSession.add(new CourseSession(7, new Date(dateFormat.parse("27-02-2018").getTime()),
                    new Date(dateFormat.parse("01-07-2018").getTime()), 30, locationDao.getLocation(1), courseDao.getCourse("BD50")));
            listCourseSession.add(new CourseSession(8, new Date(dateFormat.parse("27-02-2018").getTime()),
                    new Date(dateFormat.parse("01-07-2018").getTime()), 30, locationDao.getLocation(2), courseDao.getCourse("RE51")));
            listCourseSession.add(new CourseSession(9, new Date(dateFormat.parse("27-02-2018").getTime()),
                    new Date(dateFormat.parse("01-07-2018").getTime()), 30, locationDao.getLocation(3), courseDao.getCourse("LE08")));
            listCourseSession.add(new CourseSession(10, new Date(dateFormat.parse("01-09-2018").getTime()),
                    new Date(dateFormat.parse("01-07-2018").getTime()), 30, locationDao.getLocation(1), courseDao.getCourse("SQ40")));
            listCourseSession.add(new CourseSession(11, new Date(dateFormat.parse("01-09-2018").getTime()),
                    new Date(dateFormat.parse("01-07-2018").getTime()), 30, locationDao.getLocation(2), courseDao.getCourse("LO54")));
            listCourseSession.add(new CourseSession(12, new Date(dateFormat.parse("01-09-2018").getTime()),
                    new Date(dateFormat.parse("01-07-2018").getTime()), 30, locationDao.getLocation(3), courseDao.getCourse("EV02")));
            listCourseSession.add(new CourseSession(13, new Date(dateFormat.parse("01-09-2018").getTime()),
                    new Date(dateFormat.parse("01-07-2018").getTime()), 30, locationDao.getLocation(1), courseDao.getCourse("GE08")));
            listCourseSession.add(new CourseSession(14, new Date(dateFormat.parse("01-09-2018").getTime()),
                    new Date(dateFormat.parse("01-07-2018").getTime()), 30, locationDao.getLocation(2), courseDao.getCourse("GL51")));
            listCourseSession.add(new CourseSession(15, new Date(dateFormat.parse("01-09-2018").getTime()),
                    new Date(dateFormat.parse("01-07-2018").getTime()), 30, locationDao.getLocation(3), courseDao.getCourse("GL52")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ListIterator<CourseSession> itrCourseSession = listCourseSession.listIterator();
        while (itrCourseSession.hasNext()) {
            CourseSession courseSession = itrCourseSession.next();
            CourseSessionDao.save(courseSession);
            System.out.println(courseSession.toString());
        }
    }
}
