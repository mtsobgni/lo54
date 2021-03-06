package fr.utbm.lo54.servlet;

import fr.utbm.lo54.entity.Course;
import fr.utbm.lo54.entity.Location;
import fr.utbm.lo54.service.CourseService;
import fr.utbm.lo54.service.LocationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CourseServlet", urlPatterns = {"/courses", "/"})
public class CourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CourseService courseService = new CourseService();
        List<Course> listCourse = courseService.listCourseByFilter(request.getParameter("keyWord"),
                                                                    request.getParameter("location"),
                                                                    request.getParameter("date"));
        request.setAttribute("listCourse", listCourse);


        List<Location> listLocation;
        LocationService locationService = new LocationService();
        listLocation = locationService.listAllLocations();
        request.setAttribute("listLocation", listLocation);

        this.getServletContext().getRequestDispatcher("/WEB-INF/pages/courses.jsp").forward(request, response);
    }
}
