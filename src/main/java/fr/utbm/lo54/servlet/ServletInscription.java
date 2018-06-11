package fr.utbm.lo54.servlet;

import fr.utbm.lo54.service.ServiceCreate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Inscription" , urlPatterns = {"/inscription"})
public class ServletInscription extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean verif ;
        String lname= (String) request.getParameter("lname");
        String fname= (String) request.getParameter("fname");
        String address= (String)request.getParameter("address");
        String tel= (String) request.getParameter("tel");
        String email= (String) request.getParameter("email");
        String idsession= (String)request.getParameter("idsession");
        Integer sessionId = Integer.parseInt(idsession);

            ServiceCreate svc=  new ServiceCreate();
            verif=svc.CreateUser(sessionId,lname,fname,address,tel,email);
            if(verif){
                request.setAttribute("verif",verif);
                this.getServletContext().getRequestDispatcher( "/WEB-INF/pages/validation.jsp"
                ).forward( request, response );
            }
            else{
                request.setAttribute("idsession",idsession);
                request.setAttribute("verif",verif);
                String visibility="visible";
                String display="inline";
                request.setAttribute("display",display);
                request.setAttribute("visibility",visibility);

                this.getServletContext().getRequestDispatcher( "/WEB-INF/pages/inscription.jsp"
                ).forward( request, response );
            }

        }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idsession= (String) request.getParameter("idSession");
        String visibility="hidden";
        String display="none";
        request.setAttribute("display",display);
        request.setAttribute("idsession",idsession);
        request.setAttribute("visibility",visibility);
        this.getServletContext().getRequestDispatcher( "/WEB-INF/pages/inscription.jsp"
        ).forward( request, response );
    }
}
