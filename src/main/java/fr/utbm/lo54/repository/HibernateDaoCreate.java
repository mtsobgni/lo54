package fr.utbm.lo54.repository;

import fr.utbm.lo54.entity.Client;
import fr.utbm.lo54.entity.CourseSession;
import fr.utbm.lo54.tools.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;
import java.util.ListIterator;


public class HibernateDaoCreate {

    public void CreateClient(Integer idsession, String lname, String fname, String address, String tel, String email){
    Session session = HibernateUtil.getSessionFactory().openSession();
        try {

        session.beginTransaction();
            CourseSession CS = (CourseSession) session.get(CourseSession.class,idsession);
            Client client= new Client();
            //client.setIdClient(3);
            client.setLastname(lname);
            client.setFirstname(fname);
            client.setAddress(address);
            client.setPhone(tel);
            client.setEmail(email);
            client.setIdSession(CS);


        session.persist(client);

        session.getTransaction().commit();

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

    public List<Client> checkSession(Integer sessionId){

        List<Client> cli=null;
        Long idSession= null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from client e where e.idSession.idSession= :idSession   ");
            query.setParameter("idSession",sessionId);
            //idSession =  (Long)query.uniqueResult();
            cli=query.list();
            ListIterator<Client> li = cli.listIterator();


            while(li.hasNext()){
                System.out.println(li.next().getIdSession().getIdSession());
            }
           // System.out.println(idSession);

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
        return cli;
    }


    public List<Client> checkClient(String lname, String fname, String email){

        List<Client> cli=null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from client e where (e.lastname=:lastname AND e.firstname=:firstname) OR e.email= :email  ");
            query.setParameter("lastname",lname);
            query.setParameter("firstname",fname);
            query.setParameter("email",email);
            cli=query.list();
            ListIterator<Client> li = cli.listIterator();


            while(li.hasNext()){
                System.out.println(li.next().getIdSession().getIdSession());
            }
            // System.out.println(idSession);

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
        return cli;
    }



}
