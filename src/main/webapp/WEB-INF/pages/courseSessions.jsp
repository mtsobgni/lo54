<%@ page import="fr.utbm.lo54.entity.Course" %>
<%@ page import="fr.utbm.lo54.entity.CourseSession" %>
<%@ page import="fr.utbm.lo54.service.ClientService" %>
<%@ page import="fr.utbm.lo54.service.LocationService" %>
<%@ page import="fr.utbm.lo54.tools.Helper" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ListIterator" %>
<%@ page import="fr.utbm.lo54.service.CourseService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en" class="position-relative" style="min-height: 100%">
<head>
    <jsp:include page="head.jsp"/>
    <title> Formation </title>
</head>
<body class="mb-5">
<jsp:include page="header.jsp"/>

<main role="main" style="margin-bottom: 150px;">
    <section class="text-center bg-white mt-5">
        <div class="container">
            <div class="mt-5 mb-5">
                <%
                    CourseService courseService = new CourseService();
                    Course course = courseService.getCourse(request.getParameter("code"));
                %>
                <h3 class="font-weight-bold"><%= course.getCode() %> - <%= course.getTitle() %></h3>
            </div>
            <%
                List<CourseSession> listCourseSession = (List<CourseSession>) request.getAttribute("listCourseSession");
                if (listCourseSession == null || listCourseSession.isEmpty()) {
                } else {
            %>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>Lieu</th>
                        <th>Date de commencement</th>
                        <th>Date de fin</th>
                        <th>Nombre de personne</th>
                        <th>S'inscrire</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        ListIterator<CourseSession> itrCourseSession = listCourseSession.listIterator();
                        ClientService clientService = new ClientService();
                        LocationService locationService = new LocationService();
                        while (itrCourseSession.hasNext()) {
                            CourseSession courseSession = itrCourseSession.next();
                    %>
                    <tr>
                        <td>
                            <%= locationService.getLocation(courseSession.getId().getId()).getCity() %>
                        </td>
                        <td>
                            <%= Helper.formatFrenchDate(courseSession.getStartDate()) %>
                        </td>
                        <td>
                            <%= Helper.formatFrenchDate(courseSession.getEndDate()) %>
                        </td>
                        <td>
                            <%= clientService.getNumClient(courseSession.getIdSession()) %>/
                            <%= courseSession.getMax() %>
                        </td>
                        <td>
                            <%
                                if (clientService.getNumClient(courseSession.getIdSession())<courseSession.getMax()) {
                            %>
                            <a href="registration?idSession=<%= courseSession.getIdSession() %>">
                                S'inscrire
                            </a>
                            <%
                            } else {
                            %>
                            <a href="registration?idSession=<%= courseSession.getIdSession() %>"
                               style="color: currentColor; cursor: not-allowed; opacity: 0.5; text-decoration: none;"
                               onclick="return false">
                                S'inscrire
                            </a>
                            <%
                                }
                            %>
                        </td>
                    </tr>
                    <%}%>
                    </tbody>
                </table>
            </div>
            <% }%>
        </div>
    </section>
</main>

<jsp:include page="footer.jsp"/>
</body>
</html>