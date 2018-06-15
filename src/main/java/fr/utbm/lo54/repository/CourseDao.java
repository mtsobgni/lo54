package fr.utbm.lo54.repository;

import fr.utbm.lo54.entity.Course;
import fr.utbm.lo54.tools.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class CourseDao {


    // find a course by code
    public Course getCourse(String code) {
        Course course = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from course c where c.code = :code");
            query.setParameter("code", code);
            course = (Course) query.list().get(0);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return course;
    }

    // insert a course with a course object
    public void save(Course course) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query query = session.createSQLQuery("insert into course (code, title) values (:code, :title)");
            query.setParameter("code", course.getCode());
            query.setParameter("title", course.getTitle());
            query.executeUpdate();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    // list the course after filter
    public List<Course> getCourseByFilter(String keyWord, String locationId, String date) {
        List<Course> courseList = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            String queryVar = generateFilterQuery(keyWord, locationId, date);
            Query query = session.createQuery(queryVar);
            if (keyWord != null && !keyWord.isEmpty()) {
                query.setParameter("keyWord", "%" + keyWord + "%");
            }
            if (locationId != null && !locationId.isEmpty()) {
                query.setParameter("locationId", Integer.parseInt(locationId));
            }
            if (date != null && !date.isEmpty()) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                query.setParameter("date", new Date(formatter.parse(date).getTime()));
            }

//            System.out.println("**********QUERY**********");
//            System.out.println(queryVar);
//            System.out.println("********************");

            courseList = query.list();
        } catch (HibernateException he) {
            he.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return courseList;
    }

    // generate the query by keyword locationId and date
    public String generateFilterQuery(String keyWord, String locationId, String date) {
        String queryVar = "select distinct(c) from course_session cs, course c, location l where cs.code = c.code and cs.id = l.id";
        if (keyWord != null && !keyWord.isEmpty()) {
            queryVar += " and lower(c.title) like lower(:keyWord)";
        }
        if (locationId != null && !locationId.isEmpty()) {
            queryVar += " and l.id = :locationId";
        }
        if (date != null && !date.isEmpty()) {
            queryVar += " and :date >= cs.startDate and :date <= cs.endDate";
        }
        return queryVar;
    }

    // list all the courses
    public List<Course> getAllCourse() {
        List<Course> courseList = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query query = session.createQuery("from course c");
            courseList = query.list();
        }   catch (HibernateException he) {
            he.printStackTrace();
        }
        return courseList;
    }

}
