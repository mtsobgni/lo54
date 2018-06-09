package fr.utbm.lo54.repository;

import fr.utbm.lo54.entity.Course;
import fr.utbm.lo54.entity.CourseSession;
import fr.utbm.lo54.entity.Location;
import fr.utbm.lo54.tools.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

public class HibernateDao {


    public List<Course> doSomething() {
        List<Course> CourseList = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from course ");
            CourseList = query.list();
            ListIterator<Course> li = CourseList.listIterator();


            while (li.hasNext()) {
                System.out.println(li.next());
            }

        } catch (HibernateException he) {
            he.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        }

        return CourseList;
    }

    public List<CourseSession> filtreCourse(String keyword, String lieu) {
        List<CourseSession> CourseList = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("  from  course_session c where c.code.title like :title AND c.id.city like :city  ");
            query.setParameter("title", keyword);
            query.setParameter("city", lieu);
            CourseList = query.list();
            ListIterator<CourseSession> li = CourseList.listIterator();

            while (li.hasNext()) {
                System.out.println(li.next().getCode().getTitle());
            }

        } catch (HibernateException he) {
            he.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        }

        return CourseList;
    }

    public List<CourseSession> filtreCourseDate(String keyword, String lieu, String date) throws ParseException {
        List<CourseSession> CourseList = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        long millis = System.currentTimeMillis();
        Date date1 = new Date(millis);
        Date startDate = null;
        startDate = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime());
        try {
            Query query = session.createQuery(" from course_session c where c.code.title like :title AND c.id.city like :city  AND c.startDate between :startDate and :dayDate");
            query.setParameter("title", keyword);
            query.setParameter("city", lieu);
            query.setParameter("startDate", startDate);
            query.setParameter("dayDate", date1);
            CourseList = query.list();
            ListIterator<CourseSession> li = CourseList.listIterator();

            while (li.hasNext()) {
                System.out.println(li.next().getCode().getTitle());
            }

        } catch (HibernateException he) {
            he.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        }

        return CourseList;
    }

    public List<Location> listLocation() {
        List<Location> LocationList = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from location ");

            LocationList = query.list();
            ListIterator<Location> li = LocationList.listIterator();


            while (li.hasNext()) {
                System.out.println(li.next().getCity());
            }

        } catch (HibernateException he) {
            he.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        }

        return LocationList;
    }

    public List<CourseSession> listSession(String code, String lieu, String date) {
        List<CourseSession> CourseList = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from course_session D where D.code.code= :id AND D.id.city like :city ");
            query.setParameter("id", code);
            query.setParameter("city", lieu);

            CourseList = query.list();
            ListIterator<CourseSession> li = CourseList.listIterator();


            while (li.hasNext()) {
                System.out.println(li.next().getEndDate());
            }

        } catch (HibernateException he) {
            he.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        }

        return CourseList;
    }

    public List<CourseSession> listSessionFormationDate(String code, String lieu, String date) throws ParseException {
        List<CourseSession> CourseList = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        long millis = System.currentTimeMillis();
        Date date1 = new Date(millis);
        Date startDate = null;
        startDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime());
        try {
            Query query = session.createQuery("from course_session D where D.code.code= :id AND D.id.city like :city AND D.startDate between :startDate and :dayDate ");
            query.setParameter("id", code);
            query.setParameter("city", lieu);
            query.setParameter("startDate", startDate);
            query.setParameter("dayDate", date1);

            CourseList = query.list();
            ListIterator<CourseSession> li = CourseList.listIterator();


            while (li.hasNext()) {
                System.out.println(li.next().getEndDate());
            }


        } catch (HibernateException he) {
            he.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        }

        return CourseList;
    }

    public List<CourseSession> listSessionFormation(String code, String lieu) {
        List<CourseSession> CourseList = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from course_session D where D.code.code= :id AND D.id.city like :city  ");
            query.setParameter("id", code);
            query.setParameter("city", lieu);

            CourseList = query.list();
            ListIterator<CourseSession> li = CourseList.listIterator();


            while (li.hasNext()) {
                System.out.println(li.next().getEndDate());
            }


        } catch (HibernateException he) {
            he.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        }

        return CourseList;
    }

    public List<CourseSession> listSession(String code) {
        List<CourseSession> CourseList = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from course_session D where D.code.code= :id   ");
            query.setParameter("id", code);

            CourseList = query.list();
            ListIterator<CourseSession> li = CourseList.listIterator();


            while (li.hasNext()) {
                System.out.println(li.next().getCode().getTitle());
            }


        } catch (HibernateException he) {
            he.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        }

        return CourseList;
    }

}
