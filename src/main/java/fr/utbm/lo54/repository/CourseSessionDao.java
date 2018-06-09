package fr.utbm.lo54.repository;

import fr.utbm.lo54.entity.CourseSession;
import fr.utbm.lo54.tools.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

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
            if (!keyWord.isEmpty()) {
                query.setParameter("keyWord", keyWord);
            }
            if (!locationId.isEmpty()) {
                query.setParameter("locationId", locationId);
            }
            courseSessionList = query.list();
        }   catch (HibernateException he) {
            he.printStackTrace();
        }

        return courseSessionList;
    }

    // generate the query by keyword locationId and date
    private String generateFilterQuery(String keyWord, String locationId, String date) {
        String queryVar = "from course c where true";
        if (!keyWord.isEmpty()) {
            queryVar += "and c.code.title like :keyWord";
        }
        if (!locationId.isEmpty()) {
            queryVar += "and c.id = :locationId";
        }
//        if (!date.isEmpty()) {
//            queryVar += "and c.startDate between :startDate and :endDate";
//        }
        return queryVar;
    }
}
