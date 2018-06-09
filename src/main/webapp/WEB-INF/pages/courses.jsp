<%@ page import="java.util.List" %>
<%@ page import="java.util.ListIterator" %>
<%@ page import="fr.utbm.lo54.entity.CourseSession" %>
<%@ page import="fr.utbm.lo54.entity.Location" %>
<%@ page import="fr.utbm.lo54.service.CourseService" %>
<%@ page import="fr.utbm.lo54.tools.Helper" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
    <head>
        <jsp:include page="head.jsp"/>
        <title> Formation </title>
    </head>
    <body class="home">
    <jsp:include page="header.jsp"/>
    <br>
    <br>

    <div class="jumbotron top-space">
        <div class="container">
            <br>
            <br>
            <!--  <div  > -->
            <% String keyword = (String) request.getAttribute("keyword");%>
            <form method="POST" action="search">
                <fieldset class="recherche_p">
                    <legend>Filtrer</legend>
                    <div class="row">
                        <div class="col-sm-8">
                            <div class="form-group">
                                <div class="input-group">
                                    <% if (keyword == null) { %>
                                        <input id="s" type="text" placeholder="recherche" name="s" class="form-control left-rounded">
                                    <%} else { %>
                                        <input id="s" value="<%=request.getAttribute("keyword")%>" type="text" placeholder="recherche" name="s" class="form-control left-rounded">
                                    <% } %>
                                    <div class="input-group-btn">
                                        <button type="submit" id="rec" class="btn btn-inverse right-rounded">
                                            Chercher
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <input id="date" type="date" name="date" style="align-content: center">
                    </div>
                    <div class="form-group">
                        <div class="icon-addon addon-md">
                            <select name="lieu" class="form-control" style="width: 250px">
                                <option value="">Filtrer par lieu</option>
                                <%
                                    List<Location> listLocation;
                                    listLocation = (List<Location>) request.getAttribute("listLocation");
                                    ListIterator<Location> itrLocation = listLocation.listIterator();
                                    while (itrLocation.hasNext()) {
                                        Location location = itrLocation.next();
                                %>
                                    <option>
                                        <%= location.getCity()%>
                                    </option>
                                <%}%>
                            </select>
                            <i class="icon icon-search"></i>
                        </div>
                    </div>

                </fieldset>
            </form>
            <%
                List<CourseSession> listCourseSession = (List<CourseSession>) request.getAttribute("listCourseSession");
            %>

            <% if (listCourseSession.isEmpty()) {

            } else {
            %>
            <h2>Inscrivez vouz et commencez à suivre un cours</h2>
            <h3> Nos Formations</h3>
            <div id="lo" class="w3-container">
                <table style="width:750px" class="w3-table-all w3-hoverable">
                    <thead>
                    <tr class="w3-light-grey">
                        <th>Code</th>
                        <th>Intitulé de la formation</th>
                        <th>Date de commencement</th>
                        <th>Date de fin</th>
                        <th>S'inscrire</th>
                    </tr>
                    </thead>
                    <%
                        ListIterator<CourseSession> itrCourseSession = listCourseSession.listIterator();
                        CourseService courseService = new CourseService();
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
                            <%= Helper.formatFrenchDate(courseSession.getStartDate()) %>
                        </td>
                        <td>
                            <%= Helper.formatFrenchDate(courseSession.getEndDate()) %>
                        </td>
                        <td>
                            <a href="ServletSession">S'inscrire</a>
                        </td>
                    </tr>
                    <%}%>
                </table>
            </div>
            <% }%>

        </div>
    </div>

    <jsp:include page="footer.jsp"/>

    <script src="assets/js/recherche.js"></script>
    </body>
</html>
