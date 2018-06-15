<%@ page import="fr.utbm.lo54.entity.CourseSession" %>
<%@ page import="fr.utbm.lo54.entity.Location" %>
<%@ page import="fr.utbm.lo54.service.ClientService" %>
<%@ page import="fr.utbm.lo54.service.CourseService" %>
<%@ page import="fr.utbm.lo54.service.LocationService" %>
<%@ page import="fr.utbm.lo54.tools.Helper" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ListIterator" %>
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
            <% String keyword = (String) request.getAttribute("keyword");%>
            <div class="row mb-5">
                <form method="POST" action="courses" class="w-100">
                    <div class="form-group row">
                        <div class="col-md-12 mb-3">
                            <% if (keyword == null) { %>
                            <input id="s" type="text" placeholder="Recherche..." name="keyWord" class="form-control">
                            <%} else { %>
                            <input id="s" value="<%=request.getAttribute("keyword")%>" type="text" placeholder="Recherche..." name="keyWord" class="form-control">
                            <% } %>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-md-6 mb-3">
                            <input type="date" name="date" class="form-control">
                        </div>
                        <div class="col-md-6 mb-3">
                            <select name="location" class="form-control">
                                <option value="">Lieu</option>
                                <%
                                    List<Location> listLocation;
                                    listLocation = (List<Location>) request.getAttribute("listLocation");
                                    ListIterator<Location> itrLocation = listLocation.listIterator();
                                    while (itrLocation.hasNext()) {
                                        Location location = itrLocation.next();
                                %>
                                <option value= <%= location.getId() %>>
                                    <%= location.getCity()%>
                                </option>
                                <%}%>
                            </select>
                        </div>
                    </div>
                    <button type="submit" id="rec" class="btn btn-primary btn-lg btn-block">
                        Chercher
                    </button>
                </form>
            </div>
            <%
                List<CourseSession> listCourseSession = (List<CourseSession>) request.getAttribute("listCourseSession");

                if (listCourseSession == null || listCourseSession.isEmpty()) {
                } else {
            %>
            <h3 class="mb-4"> Nos Formations</h3>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                        <tr>
                            <th>Code</th>
                            <th>Intitulé de la formation</th>
                            <th>Lieu</th>
                            <th>Date de commencement</th>
                            <th>Date de fin</th>
                            <th>Remplissage</th>
                            <th>S'inscrire</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ListIterator<CourseSession> itrCourseSession = listCourseSession.listIterator();
                            CourseService courseService = new CourseService();
                            ClientService clientService = new ClientService();
                            LocationService locationService = new LocationService();
                            while (itrCourseSession.hasNext()) {
                                CourseSession courseSession = itrCourseSession.next();
                        %>
                        <tr>
                            <td>
                                <%= courseSession.getCode().getCode() %>
                            </td>
                            <td>
                                <%= courseService.getCourse(courseSession.getCode().getCode()).getTitle() %>
                            </td>
                            <td>
                                <%= locationService.getLocation(courseSession.getId().getId()).getCity() %>
                            </td>
                            <td>
                                <%= Helper.formatFrenchDate(courseSession.getStartDate()) %>
                            </td>
                            <td>
                                <%= Helper.formatFrenchDate(courseSession.getEndDate()) %>
                            </td>
                            <td class="text-center">
                                <%= clientService.getNumClient(courseSession.getIdSession()) %>/
                                <%= courseSession.getMax() %>
                            </td>
                            <td>
                                <a href="registration?idSession=<%= courseSession.getIdSession() %>">S'inscrire</a>
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
