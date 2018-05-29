package fr.utbm.lo54.service;

import fr.utbm.lo54.entity.Course;
import fr.utbm.lo54.entity.CourseSession;
import fr.utbm.lo54.entity.Location;
import fr.utbm.lo54.repository.HibernateDao;

import java.sql.Date;
import java.util.List;
public class ListeFormation {
    public List<Course> listeCourse(){
        List<Course> list;
        HibernateDao hb1= new HibernateDao();
        list=hb1.doSomething();
        return list;
    }
    public List<Location> listLocation(){

        List<Location> list;
        HibernateDao hb1= new HibernateDao();
        list=hb1.listLocation();
        return list;

    }
    public List<CourseSession> listeSession(String code, String lieu, String date){
        List<CourseSession> list;
        HibernateDao hb1= new HibernateDao();
        list=hb1.listSession(code, lieu, date);
        return list;
    }

    public List<CourseSession> filtreCourse(String code, String lieu, Date date){
        List<CourseSession> list;
        HibernateDao hb1= new HibernateDao();
        list=hb1.filtreCourse(code, lieu, date);
        return list;
    }
}
