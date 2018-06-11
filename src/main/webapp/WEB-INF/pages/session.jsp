<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="fr.utbm.lo54.entity.CourseSession" %>
<%@ page import="java.util.ListIterator" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Bike
  Date: 26/05/2018
  Time: 00:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <jsp:include page="enTete.jsp" />
    <title>Session</title>
</head>
<body class="home">
<jsp:include page="header.jsp" />
<br>
<br>

<div class="jumbotron top-space">
    <div class="container">
        <br>
        <br>
        <h2> ${titre}</h2>
        <!--<h2> <%= request.getAttribute("titre")%></h2> -->
        <c:choose>
        <c:when test="${ empty listSession }">
            <div>
                <h2>Aucun résultat pour la recherche demander</h2>
            </div>
        </c:when>
        <c:otherwise>
        <h2>Inscrivez vouz à une session et commencez à suivre le cours</h2>
        <h3> Sessions pour ce Cours</h3>
            <div id="lo" class="w3-container">
                <table style="width:750px" class="w3-table-all w3-hoverable">
                    <thead>
                    <tr class="w3-light-grey">
                        <th>Id Session</th>
                        <th>Lieu</th>
                        <th>Date de début</th>
                        <th>Date de fin </th>
                        <th>Nombre de personne inscrit</th>
                        <th>S'inscrire à cette session</th>
                    </tr>
                    </thead>
                    <c:forEach items="${ listSession }" var="session" varStatus="status">
                        <tr>
                            <td><c:out value="${ session.idSession }" /></td>
                            <td><c:out value="${ session.id.city }" /></td>
                            <td><c:out value="${ session.startDate }" /></td>
                            <td><c:out value="${ session.endDate }" /></td>
                            <jsp:useBean id="idSession" class="fr.utbm.lo54.service.ListeFormation"/>
                            <c:set var="inscrit" value="${idSession.userSession(session.idSession)}" scope="page" />
                            <td><c:out value="${inscrit}/${ session.max }" /></td>
                            <td><a href="inscription?idSession=${session.idSession}">S'inscrire à une session </a></td>
                        </tr>
                    </c:forEach>
                </table>
                </c:otherwise>
                </c:choose>
            </div>

    </div>
</div>

<jsp:include page="footer.jsp" />

</body>
</html>