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


@WebServlet(name="Formation" , urlPatterns = {"/formation"})
public class ServletFormation extends HttpServlet {

        public void doGet(HttpServletRequest request, HttpServletResponse
                response ) throws ServletException, IOException {

            List<Course> result;
            List<Location> resultat;
            ListeFormation sv1= new ListeFormation();
            result=sv1.listeCourse();
            resultat=sv1.listLocation();

            request.setAttribute( "list", result );
            request.setAttribute( "liste", resultat );

            this.getServletContext().getRequestDispatcher( "/WEB-INF/pages/formation.jsp"
            ).forward( request, response );
        }

    public void doPost(HttpServletRequest request, HttpServletResponse
            response ) throws ServletException, IOException {


    }
}
