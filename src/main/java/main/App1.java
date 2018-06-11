package main;

import fr.utbm.lo54.entity.CourseSession;
import fr.utbm.lo54.repository.HibernateDao;
import fr.utbm.lo54.repository.HibernateDaoCreate;
import fr.utbm.lo54.service.ListeFormation;
import fr.utbm.lo54.service.ServiceCreate;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ListIterator;

public class App1 {

    public static void main(String[] args) throws ParseException {
//.parse(date).getTime());
        boolean exe;
        List<CourseSession> list;
        HibernateDao test = new HibernateDao();
        HibernateDaoCreate hbCreate= new HibernateDaoCreate();
        ListeFormation tt= new ListeFormation();
        // list=tt.listeSession("1");
        long millis=System.currentTimeMillis();
        java.util.Date date1 = new Date(millis);
        String date="2011-05-01";
        //test.doSomethingdo();

      // hbCreate.CreateClient(1,"t","p","h","p","ml");
       test.filtreCourse("%","%");

    }
}
