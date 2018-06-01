package fr.utbm.lo54.servlet;

import fr.utbm.lo54.entity.Course;
import fr.utbm.lo54.entity.CourseSession;
import fr.utbm.lo54.entity.Location;
import fr.utbm.lo54.service.ListeFormation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;

@WebServlet(name="ServletSearch" , urlPatterns = {"/search"})
public class ServletSearch extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request.setAttribute( "test", message );
        String search= (String) request.getParameter("s");
        String lieu= (String) request.getParameter("lieu");
        String date= (String)request.getParameter("date");
        request.setAttribute("lieu",lieu);
        request.setAttribute("date",date);
        request.setAttribute("keyword",search);
        search="%" + search+ "%";
        lieu="%" + lieu + "%";
        List<CourseSession> result=null;
        ListeFormation sv1= new ListeFormation();
       // long millis=System.currentTimeMillis();
        //Date date1 = new Date(millis);
        if(date.isEmpty()){
            result=sv1.filtreCourse(search, lieu);

        }
        else{

            try {
                result=sv1.filtreCourseDate(search, lieu, date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        request.setAttribute( "list", result );

        List<Location> resultat;
        ListeFormation sv2= new ListeFormation();
        resultat=sv2.listLocation();
        request.setAttribute( "liste", resultat );
        this.getServletContext().getRequestDispatcher( "/WEB-INF/pages/search.jsp"
        ).forward( request, response );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//  request.setAttribute( "test", message );

    }
}
