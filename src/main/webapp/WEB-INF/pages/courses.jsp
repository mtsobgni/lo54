<%@ page import="fr.utbm.lo54.entity.Course" %>
<%@ page import="fr.utbm.lo54.entity.Location" %>
<%@ page import="fr.utbm.lo54.service.CourseService" %>
<%@ page import="fr.utbm.lo54.service.LocationService" %>
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
                List<Course> listCourse = (List<Course>) request.getAttribute("listCourse");

                if (listCourse == null || listCourse.isEmpty()) {
                } else {
            %>
            <h3 class="mb-4"> Nos Formations</h3>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                        <tr>
                            <th>Code</th>
                            <th>Intitulé de la formation</th>
                            <th>S'inscrire</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ListIterator<Course> itrCourse = listCourse.listIterator();
                            while (itrCourse.hasNext()) {
                                Course course = itrCourse.next();
                        %>
                        <tr>
                            <td>
                                <%= course.getCode() %>
                            </td>
                            <td>
                                <%= course.getTitle() %>
                            </td>
                            <td>
                                <a href="courseSessions?code=<%= course.getCode() %>">S'inscrire</a>
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
