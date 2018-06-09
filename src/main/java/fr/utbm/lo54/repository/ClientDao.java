package fr.utbm.lo54.repository;

import fr.utbm.lo54.entity.Client;
import fr.utbm.lo54.tools.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class ClientDao {

    // insert a client with a client object
    public void save(Client client) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query query = session.createSQLQuery("insert into client (id_client, lastname, firstname, address, phone, email) " +
                                                    "values (:id_client, :lastname, :firstname, :address, :phone, :email)");
            query.setParameter("id_client", client.getIdClient());
            query.setParameter("lastname", client.getLastname());
            query.setParameter("firstname", client.getFirstname());
            query.setParameter("address", client.getAddress());
            query.setParameter("phone", client.getPhone());
            query.setParameter("email", client.getEmail());
            query.executeUpdate();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

}
