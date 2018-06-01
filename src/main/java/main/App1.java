package main;

import fr.utbm.lo54.entity.CourseSession;
import fr.utbm.lo54.repository.HibernateDao;
import fr.utbm.lo54.service.ListeFormation;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class App1 {

    public static void main(String[] args) throws ParseException {
//.parse(date).getTime());
        List<CourseSession> list;
        HibernateDao test = new HibernateDao();
        ListeFormation tt= new ListeFormation();
       // list=tt.listeSession("1");
        long millis=System.currentTimeMillis();
        java.util.Date date1 = new Date(millis);
        String date="2011-05-01";
       // test.doSomethingdo();
        tt.listeSessionFormation("1","%");
       // Date tesr = new java.util.Date(new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime());
        test.filtreCourse("%", "%");
    }
}

