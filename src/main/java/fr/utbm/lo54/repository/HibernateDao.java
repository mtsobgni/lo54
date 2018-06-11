package fr.utbm.lo54.repository;

import fr.utbm.lo54.entity.Client;
import fr.utbm.lo54.entity.Course;
import fr.utbm.lo54.entity.CourseSession;
import fr.utbm.lo54.entity.Location;
import fr.utbm.lo54.tools.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ListIterator;

public class HibernateDao {


    public  List<Course> doSomething() {
        List<Course> CourseList=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from course ");
          //  Query query = session.createQuery("insert into Course(title) values ('programmation Java') ");

             CourseList = query.list();
            ListIterator<Course> li = CourseList.listIterator();


while(li.hasNext()){
    System.out.println(li.next());
}
            //session.getTransaction().commit();


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

  /*      finally {
            if(session != null) {
                try { session.close();

				...
    }
*/
       return CourseList;
    }

    public  List<Object []> filtreCourse(String keyword, String lieu) {
        lieu="%"+lieu+"%";
        keyword= "%"+keyword+"%";
        List<Object[]> CourseSessions=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("select distinct c.code.code, c.code.title from course_session c where c.code.title like :title AND c.id.city like :city ");
            query.setParameter("title",keyword);
            query.setParameter("city",lieu);
             CourseSessions= (List<Object[]>)query.list();
           for (Object[] CourseSession: CourseSessions){
                String code= (String)CourseSession[0];
                System.out.println(code);
                String name = (String)CourseSession[1];
                System.out.println(name);
            }
            //session.getTransaction().commit();


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

  /*      finally {
            if(session != null) {
                try { session.close();

				...
    }
*/
        return CourseSessions;
    }

    public  List<Object []> filtreCourseDate(String keyword, String lieu, String date) throws ParseException {
        lieu="%"+lieu+"%";
        keyword= "%"+keyword+"%";
        List<Object[]> CourseSessions=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        long millis=System.currentTimeMillis();
        Date date1 = new Date(millis);
        Date startDate = null;

        startDate = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime());

        try {
            Query query = session.createQuery(" select distinct c.code.code, c.code.title from course_session c where c.code.title like :title AND c.id.city like :city  AND c.startDate between :dayDate and :startDate");
           // Query query = getSession().createQuery("from java_pojo_name");
            query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            //query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            //return query.list();
            query.setParameter("title",keyword);
            query.setParameter("city",lieu);
            query.setParameter("startDate",startDate);
            query.setParameter("dayDate",date1);

            CourseSessions= (List<Object[]>)query.list();
           /* ListIterator<CourseSession> li = CourseList.listIterator();


            while(li.hasNext()){
                System.out.println(li.next().getStartDate());
            }*/
            //session.getTransaction().commit();


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

  /*      finally {
            if(session != null) {
                try { session.close();

				...
    }
*/
        return CourseSessions;
    }

    public  List<Location> listLocation() {
        List<Location> LocationList=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from location ");

            LocationList = query.list();
            ListIterator<Location> li = LocationList.listIterator();


            while(li.hasNext()){
                System.out.println(li.next().getCity());
            }
            //session.getTransaction().commit();


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

  /*      finally {
            if(session != null) {
                try { session.close();

				...
    }
*/
        return LocationList;
    }

    public  List<CourseSession> otherListSession(String code, String lieu, String date) {
        List<CourseSession> CourseList=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from course_session D where D.code.code= :id AND D.id.city like :city ");
           query.setParameter("id",code);
            query.setParameter("city",lieu);
            //  Query query = session.createQuery("insert into Course(title) values ('programmation Java') ");

            CourseList = query.list();
            ListIterator<CourseSession> li = CourseList.listIterator();


            while(li.hasNext()){
                System.out.println(li.next().getEndDate());
            }
            //session.getTransaction().commit();


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

  /*      finally {
            if(session != null) {
                try { session.close();

				...
    }
*/
        return CourseList;
    }

    public  List<CourseSession> listSessionFormationDate(String code, String lieu, String date) throws ParseException  {
        List<CourseSession> CourseList=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        long millis=System.currentTimeMillis();
        Date date1 = new Date(millis);
        Date startDate = null;
            startDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime());
        try {
            Query query = session.createQuery("from course_session D where D.code.code= :id AND D.id.city like :city AND D.startDate between :dayDate and :startDate ");
            query.setParameter("id",code);
            query.setParameter("city",lieu);
            query.setParameter("startDate",startDate);
            query.setParameter("dayDate",date1);
            //  Query query = session.createQuery("insert into Course(title) values ('programmation Java') ");

            CourseList = query.list();
            ListIterator<CourseSession> li = CourseList.listIterator();


            while(li.hasNext()){
                System.out.println(li.next().getStartDate());
            }
            //session.getTransaction().commit();


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

  /*      finally {
            if(session != null) {
                try { session.close();

				...
    }
*/
        return CourseList;
    }

    public  List<CourseSession> listSessionFormation(String code, String lieu) {
        List<CourseSession> CourseList=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from course_session D where D.code.code= :id AND D.id.city like :city  ");
            query.setParameter("id",code);
            query.setParameter("city",lieu);
            //  Query query = session.createQuery("insert into Course(title) values ('programmation Java') ");

            CourseList = query.list();
            ListIterator<CourseSession> li = CourseList.listIterator();


            while(li.hasNext()){
                System.out.println(li.next().getStartDate());
            }
            //session.getTransaction().commit();


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

  /*      finally {
            if(session != null) {
                try { session.close();

				...
    }
*/
        return CourseList;
    }

    public  List<CourseSession> listSession(String code) {
        List<CourseSession> CourseList=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from course_session D where D.code.code= :id   ");
            query.setParameter("id",code);
            //  Query query = session.createQuery("insert into Course(title) values ('programmation Java') ");

            CourseList = query.list();
            ListIterator<CourseSession> li = CourseList.listIterator();


            while(li.hasNext()){
                System.out.println(li.next().getCode().getTitle());
            }
            //session.getTransaction().commit();


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

  /*      finally {
            if(session != null) {
                try { session.close();

				...
    }
*/
        return CourseList;
    }


    public void doSomethingdo() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {

            java.sql.Date date_str = null;
            java.sql.Date date_end = null;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date1 = "2018-06-08";
            String date2 = "2018-10-01";
            try {
                //date_str = (java.sql.Date) simpleDateFormat.parse(date1);
                date_str = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(date1).getTime());
                System.out.println(date_str);
                //date_end = (java.sql.Date) simpleDateFormat.parse(date2);
                date_end = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(date2).getTime());
                System.out.println(date_end);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            long millis=System.currentTimeMillis();
            //Date date1 = new Date("");
            //Date date2 = new Date(millis);
            session.beginTransaction();
            Course co = new Course("4","BASE DE DONNES");
Location lc = new Location(1,"MARSEILLE");
            Location location1 = (Location) session.get(Location.class,1);
            CourseSession courseSession2= (CourseSession) session.get(CourseSession.class,2);
            Course course1= (Course) session.get(Course.class,"4");
            CourseSession cs = new CourseSession(8,date_str,date_end,25,location1, course1);
           // Client client= new Client(2, "Loick", "TSOBGNI","3 rue gaston deferre",07,"benito.tsobgni@yahoo.fr",courseSession2);


            session.persist(lc);
            //CourseSession courseSession = (CourseSession) session.get(CourseSession.class, 1);
            session.getTransaction().commit();
            // System.out.println(location1.getCity());
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

  /*      finally {
            if(session != null) {
                try { session.close();

				...
    }
*/
    }


    public Long userSession(Integer sessionId){
        Long count= null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("select count(e) from client e where e.idSession.idSession= :idSession   ");
            query.setParameter("idSession",sessionId);
            count =  (Long)query.uniqueResult();
            System.out.println(count);

            //session.getTransaction().commit();

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

  /*      finally {
            if(session != null) {
                try { session.close();

				...
    }
*/
        return count;
    }

    public  List<CourseSession> listClient() {
        List<CourseSession> ClientList=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from course_session ");

            ClientList = query.list();
            ListIterator<CourseSession> li = ClientList.listIterator();


            while(li.hasNext()){
                System.out.println(li.next().getIdSession());
            }
            //session.getTransaction().commit();


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

  /*      finally {
            if(session != null) {
                try { session.close();

				...
    }
*/
        return ClientList;
    }

}
