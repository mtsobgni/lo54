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
import java.util.List;

@WebServlet(name="ServletSession" , urlPatterns = {"/ServletSession"})
public class ServletSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = (String)request.getParameter("code");
        String titre = (String)request.getParameter("titre");
        String lieu = (String)request.getParameter("lieu");
        String date = (String)request.getParameter("date");
        List<CourseSession> reslt;
        ListeFormation sv1= new ListeFormation();
        reslt=sv1.listeSession(code, lieu, date);
        request.setAttribute("listSession",reslt);
        request.setAttribute("title",titre);
        this.getServletContext().getRequestDispatcher( "/WEB-INF/pages/session.jsp"
        ).forward( request, response );
    }
}
