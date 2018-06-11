package fr.utbm.lo54.servlet;

import fr.utbm.lo54.entity.CourseSession;
import fr.utbm.lo54.service.CourseSessionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CourseSessionServlet", urlPatterns = {"/courseSessions"})
public class CourseSessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CourseSessionService courseSessionService = new CourseSessionService();
        List<CourseSession> listCourseSession = (List<CourseSession>) courseSessionService.listCourseSessionByCode(request.getParameter("code"));
        request.setAttribute("listCourseSession", listCourseSession);
        this.getServletContext().getRequestDispatcher("/WEB-INF/pages/courseSessions.jsp").forward(request, response);
    }
}
