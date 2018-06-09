package fr.utbm.lo54.repository;

import fr.utbm.lo54.entity.CourseSession;
import fr.utbm.lo54.tools.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class CourseSessionDao {

    // to list all the course_session
    public List<CourseSession> getAllCourseSessions() {
        List<CourseSession> courseSessionList = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query query = session.createQuery("  from  course_session c");
            courseSessionList = query.list();

//            ListIterator<CourseSession> li = courseSessionList.listIterator();
//            while (li.hasNext()) {
//                System.out.println(li.next().getCode().getTitle());
//            }
        }   catch (HibernateException he) {
            he.printStackTrace();
        }
        return courseSessionList;
    }

    // to list the course_session after filter
    public List<CourseSession> getCourseSessionByFilter(String keyWord, String date, String location ) {
        List<CourseSession> courseSessionList = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {

        }   catch (HibernateException he) {
            he.printStackTrace();
        }

        return courseSessionList;
    }

    // to insert a course with a course object
    public void save(CourseSession courseSession) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query query = session.createSQLQuery("insert into course_session (id_session, start_date, end_date, max, id, code)" +
                                                    " values (:id_session, :start_date, :end_date, :max, :id, :code)");
            query.setParameter("id_session", courseSession.getIdSession());
            query.setTimestamp("start_date", courseSession.getStartDate());
            query.setTimestamp("end_date", courseSession.getEndDate());
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
}
