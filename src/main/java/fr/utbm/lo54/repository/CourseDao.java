package fr.utbm.lo54.repository;

import fr.utbm.lo54.entity.Course;
import fr.utbm.lo54.tools.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class CourseDao {

    // to insert a course with a course object
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

    // to find a course by code
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

}
