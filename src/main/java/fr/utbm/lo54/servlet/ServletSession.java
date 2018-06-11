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
import java.text.ParseException;
import java.util.List;

@WebServlet(name="ServletSession" , urlPatterns = {"/ServletSession"})
public class ServletSession extends HttpServlet  {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code ;
        String lieu;
        String date;
        code = (request.getParameter("code") != null) ? request.getParameter("code") : "null";
        lieu = (request.getParameter("lieu") != null) ? request.getParameter("lieu") : "null";
        date = (request.getParameter("date") != null) ? request.getParameter("date") : "null";
        String titre = request.getParameter("titre");

        List<CourseSession> reslt= null;
        ListeFormation sv1= new ListeFormation();

        try {
            reslt=sv1.SessionFormationDate(code, lieu, date);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        request.setAttribute("lieu",lieu);
        request.setAttribute("code",code);
        request.setAttribute("date",date);
        request.setAttribute("titre",titre);
        request.setAttribute("listSession",reslt);

        this.getServletContext().getRequestDispatcher( "/WEB-INF/pages/session.jsp"
        ).forward( request, response );

    }
}
