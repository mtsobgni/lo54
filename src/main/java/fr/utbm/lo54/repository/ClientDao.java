package fr.utbm.lo54.repository;

import fr.utbm.lo54.entity.Client;
import fr.utbm.lo54.tools.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import static java.lang.Math.toIntExact;

public class ClientDao {

    // insert a client with a client object
    public void save(Client client) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query query = session.createSQLQuery("insert into client (lastname, firstname, address, phone, email, id_session) " +
                                                    "values (:lastname, :firstname, :address, :phone, :email, :idSession)");
            query.setParameter("lastname", client.getLastname());
            query.setParameter("firstname", client.getFirstname());
            query.setParameter("address", client.getAddress());
            query.setParameter("phone", client.getPhone());
            query.setParameter("email", client.getEmail());
            query.setParameter("idSession", client.getIdSession().getIdSession());
            query.executeUpdate();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

    // get the number of clients who have registered the course session
    public int getNumClient(int idSession) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        int num = 0;
        try {
            session.beginTransaction();
            Query query = session.createQuery("select count(*) from client c, course_session cs " +
                                                    "where c.idSession = cs.idSession and cs.idSession = :idSession");
            query.setParameter("idSession", idSession);
            num = toIntExact((Long) query.list().get(0));

        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            session.getTransaction().commit();
            session.close();
        }
        return num;
    }

}
