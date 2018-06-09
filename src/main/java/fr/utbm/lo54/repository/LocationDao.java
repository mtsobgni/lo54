package fr.utbm.lo54.repository;

import fr.utbm.lo54.entity.Location;
import fr.utbm.lo54.tools.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class LocationDao {

    // list all the locations
    public List<Location> getAllLocations() {
        List<Location> LocationList = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from location ");
            LocationList = query.list();

//            ListIterator<Location> li = LocationList.listIterator();
//            while (li.hasNext()) {
//                System.out.println(li.next().getCity());
//            }
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return LocationList;
    }

    // find a location by id
    public Location getLocation(int id) {
        Location location = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("from location l where l.id = :id");
            query.setParameter("id", id);
            location = (Location) query.list().get(0);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return location;
    }

    // insert a location with a location object
    public void save(Location location) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query query = session.createSQLQuery("insert into location (id, city) values (:id, :city)");
            query.setParameter("id", location.getId());
            query.setParameter("city", location.getCity());
            query.executeUpdate();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }

}
