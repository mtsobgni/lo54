package fr.utbm.lo54.servlet;

import fr.utbm.lo54.entity.Course;
import fr.utbm.lo54.service.ListeFormation;
import fr.utbm.lo54.tools.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindServlet", urlPatterns = {"/find"})
public class FindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       // this.getServletContext().getRequestDispatcher( "/WEB-INF/pages/formation.jsp"
      //  ).forward( request, response );
        String keyword = (String) request.getParameter("val");
        List<Course> result;
        ListeFormation sv1= new ListeFormation();
        result=sv1.listeCourse();
        request.setAttribute( "list", result );
         this.getServletContext().getRequestDispatcher( "/WEB-INF/pages/find.jsp"
          ).forward( request, response );

       // response.setContentType("text/plain");
        //response.getWriter().write(keyword);
    }
}