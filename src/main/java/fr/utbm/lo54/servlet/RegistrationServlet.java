package fr.utbm.lo54.servlet;

import fr.utbm.lo54.service.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", urlPatterns = {"/registration"})
public class RegistrationServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClientService clientService = new ClientService();
        clientService.registerClient(request.getParameter("firstname"),
                                        request.getParameter("lastname"),
                                        request.getParameter("address"),
                                        request.getParameter("phone"),
                                        request.getParameter("email"),
                                        Integer.parseInt(request.getParameter("idSession")));
        this.getServletContext().getRequestDispatcher("/courses").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/pages/registration.jsp").forward(request, response);
    }
}
