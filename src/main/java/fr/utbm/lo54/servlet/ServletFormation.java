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
import java.util.List;


@WebServlet(name = "Formation", urlPatterns = {"/formation"})
public class ServletFormation extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  request.setAttribute( "test", message );
        List<Course> result;
        ListeFormation sv1 = new ListeFormation();
        result = sv1.listeCourse();
        request.setAttribute("list", result);
        List<Location> resultat;
        ListeFormation sv2 = new ListeFormation();
        resultat = sv2.listLocation();
        request.setAttribute("liste", resultat);
        this.getServletContext().getRequestDispatcher("/WEB-INF/pages/formation.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request.setAttribute( "test", message );
        String search = (String) request.getParameter("s");
        String lieu = (String) request.getParameter("lieu");
        String date = (String) request.getParameter("date");
        request.setAttribute("lieu", lieu);
        request.setAttribute("date", date);
        request.setAttribute("keyword", search);
        search = "%" + search;
        List<CourseSession> result;
        ListeFormation sv1 = new ListeFormation();
        long millis = System.currentTimeMillis();
        Date date1 = new Date(millis);
        result = sv1.filtreCourse(search, lieu);
        request.setAttribute("list", result);
        List<Location> resultat;
        ListeFormation sv2 = new ListeFormation();
        resultat = sv2.listLocation();
        request.setAttribute("liste", resultat);
        this.getServletContext().getRequestDispatcher("/WEB-INF/pages/formation.jsp").forward(request, response);
    }
}
