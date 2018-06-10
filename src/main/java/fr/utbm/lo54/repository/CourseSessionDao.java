package fr.utbm.lo54.repository;

import fr.utbm.lo54.entity.CourseSession;
import fr.utbm.lo54.tools.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class CourseSessionDao {

    // get course session by id_session
    public  CourseSession getCourseSession(int id) {
        CourseSession courseSession = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from course_session c where c.idSession = :idSession");
            query.setParameter("idSession", id);
            courseSession = (CourseSession) query.list().get(0);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return courseSession;
    }

    // list all the course_session
    public List<CourseSession> getAllCourseSessions() {
        List<CourseSession> courseSessionList = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from course_session c");
            courseSessionList = query.list();
        }   catch (HibernateException he) {
            he.printStackTrace();
        }
        return courseSessionList;
    }

    // insert a course with a course object
    public void save(CourseSession courseSession) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query query = session.createSQLQuery("insert into course_session (idSession, startDate, endDate, max, id, code)" +
                                                    " values (:idSession, :startDate, :endDate, :max, :id, :code)");
            query.setParameter("idSession", courseSession.getIdSession());
            query.setTimestamp("startDate", courseSession.getStartDate());
            query.setTimestamp("endDate", courseSession.getEndDate());
            query.setParameter("max", courseSession.getMax());
            query.setParameter("id", courseSession.getId());
            query.setParameter("code", courseSession.getCode());
            query.executeUpdate();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    // list the course after filter
    public List<CourseSession> getCourseSessionByFilter(String keyWord, String locationId, String date) {
        List<CourseSession> courseSessionList = null;
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

            courseSessionList = query.list();
        } catch (HibernateException he) {
            he.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return courseSessionList;
    }

    // generate the query by keyword locationId and date
    private String generateFilterQuery(String keyWord, String locationId, String date) {
        String queryVar = "select cs from course_session cs, course c, location l where cs.code = c.code and cs.id = l.id";
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
}
