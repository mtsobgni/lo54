package fr.utbm.lo54.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="HomeFormation" , urlPatterns = {"/home"})
public class ServletHome extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse
            response ) throws ServletException, IOException {
        // request.setAttribute( "test", message );
      //  request.setAttribute( "list", result );
        this.getServletContext().getRequestDispatcher( "/WEB-INF/pages/home.jsp"
        ).forward( request, response );
    }

    public void doPost(HttpServletRequest request, HttpServletResponse
            response ) throws ServletException, IOException {
        // request.setAttribute( "test", message );
        //  request.setAttribute( "list", result );
        this.getServletContext().getRequestDispatcher( "/WEB-INF/pages/home.jsp"
        ).forward( request, response );
    }
}

