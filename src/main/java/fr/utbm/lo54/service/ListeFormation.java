package fr.utbm.lo54.service;

import fr.utbm.lo54.entity.Course;
import fr.utbm.lo54.entity.CourseSession;
import fr.utbm.lo54.entity.Location;
import fr.utbm.lo54.repository.HibernateDao;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;
public class ListeFormation {

    private HibernateDao hb1;

    public ListeFormation(HibernateDao hb1) {
        this.hb1 = hb1;
    }

    public ListeFormation(){
        hb1= new HibernateDao();
    };

    public List<Course> listeCourse(){
        List<Course> list;
        list=hb1.doSomething();
        return list;
    }
    public List<Location> listLocation(){

        List<Location> list;
        list=hb1.listLocation();
        return list;

    }
 /*   public List<CourseSession> listeSessionFormation(String code, String lieu){
        List<CourseSession> list;
        list=hb1.listSessionFormation(code, lieu);
        return list;
    }

    public List<CourseSession> listeSession(String code){
        List<CourseSession> list;
        list=hb1.listSession(code);
        return list;
    }


    public List<CourseSession> listeSessionFormationDate(String code, String lieu, String date)throws ParseException{
        List<CourseSession> list;
        list=hb1.listSessionFormationDate(code, lieu, date);
        return list;
    }


    public List<CourseSession> filtreCourse(String code, String lieu){
        List<CourseSession> list;
        list=hb1.filtreCourse(code, lieu);
        return list;
    }

    public List<CourseSession> filtreCourseDate(String code, String lieu, String date) throws ParseException {
        List<CourseSession> list;
        list=hb1.filtreCourseDate(code, lieu, date);
        return list;
    }*/

    public List<Object []>filtreFormationDate(String code, String lieu, String date){

        List<Object []> result=null;
     //   code="%" + code+ "%";
     //   lieu="%" + lieu + "%";

        if(date.isEmpty()){
            result=hb1.filtreCourse(code, lieu);

        }
        else{

            try {
                result=hb1.filtreCourseDate(code, lieu, date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public List<CourseSession> SessionFormationDate(String code, String lieu, String date)throws ParseException{
        List<CourseSession> reslt=null;

        if(lieu.isEmpty() && date.isEmpty()){
            reslt=hb1.listSession(code);
        }
        else if (date.isEmpty()){
            lieu="%" + lieu + "%";
            reslt=hb1.listSessionFormation(code,lieu);
        }
        else  {
            try {
                reslt=hb1.listSessionFormationDate(code,lieu,date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return reslt;
    }

    public Long userSession(Integer idSession){

        Long count=null;
        count=hb1.userSession(idSession);
        System.out.println(count);
        return count;
    }

}
