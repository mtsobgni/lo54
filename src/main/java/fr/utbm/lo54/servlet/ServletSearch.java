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

        String search= (String) request.getParameter("keyword");
        String lieu= (String) request.getParameter("lieu");
        String date= (String)request.getParameter("date");

        List<Location> resultat=null;
        List<Object []> result=null;

        ListeFormation sv1= new ListeFormation();

        result=sv1.filtreFormationDate(search,lieu, date);
        resultat=sv1.listLocation();

        request.setAttribute( "list", result );
        request.setAttribute( "liste", resultat );
        request.setAttribute("lieu",lieu);
        request.setAttribute("date",date);
        request.setAttribute("keyword",search);

        this.getServletContext().getRequestDispatcher( "/WEB-INF/pages/search.jsp"
        ).forward( request, response );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
