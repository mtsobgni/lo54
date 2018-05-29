package fr.utbm.lo54.repository;


import fr.utbm.lo54.entity.Client;
import fr.utbm.lo54.entity.Course;
import fr.utbm.lo54.entity.CourseSession;
import fr.utbm.lo54.entity.Location;
import fr.utbm.lo54.tools.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.Date;
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

    public  List<CourseSession> filtreCourse(String keyword, String lieu, Date date) {
        List<CourseSession> CourseList=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from course_session c where c.code.title like :title OR c.id.city=:city OR c.startDate >= :startDate ");
            //  Query query = session.createQuery("insert into Course(title) values ('programmation Java') ");
            query.setParameter("title",keyword);
            query.setParameter("city",lieu);
            query.setParameter("startDate",date);
         //   final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
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


    public  List<Location> listLocation() {
        List<Location> LocationList=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from location ");
            //  Query query = session.createQuery("insert into Course(title) values ('programmation Java') ");

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

    public  List<CourseSession> listSession(String code, String lieu, String date) {
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



    public void doSomethingdo() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            //Query query = session.createQuery("from course_session where idSession=1 ");
            //  Query query = session.createQuery("insert into Course(title) values ('programmation Java') ");

            //List<CourseSession> CourseSessionList = query.list();
            //ListIterator<CourseSession> li = CourseSessionList.listIterator();
           // while (li.hasNext()){
             //   System.out.println(li.next().getId().getCity());
           // }

            long millis=System.currentTimeMillis();
            Date date1 = new Date(millis);
            Date date2 = new Date(millis);
            session.beginTransaction();
            Location location1 = (Location) session.get(Location.class,3);
            CourseSession courseSession2= (CourseSession) session.get(CourseSession.class,2);
            Course course1= (Course) session.get(Course.class,"2");
            Client client= new Client(2, "Loick", "TSOBGNI","3 rue gaston deferre",07,"benito.tsobgni@yahoo.fr",courseSession2);
            CourseSession courseSession1= new CourseSession (3,date1,date2,5,location1,course1);
            //Course Course1 = new Course("3","ANGLAIS");
            //Course1.setTitle("Programmation JAVA");
            //CourseSession courseSession1 = new CourseSession(1,"20/11/2017", "22/11/2017",14);
            // CourseSession courseSession1 = new CourseSession();
            // courseSession1.setId(1);




            //System.out.println(formater.format(aujourdhui));

            // courseSession1.setStartDate(date1);
            // courseSession1.setEndDate(date2);
            // courseSession1.setMax(13);
            // courseSession1.setId(1);
            // courseSession1.setCode("1");


            //session.persist(client);
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

}
