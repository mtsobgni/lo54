package main;

import fr.utbm.lo54.repository.HibernateDao;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class App1 {

    public static void main(String[] args) {

        HibernateDao test = new HibernateDao();
        long millis=System.currentTimeMillis();
        Date date1 = new Date(millis);
        test.filtreCourse("%", "%",date1);
    }
}

