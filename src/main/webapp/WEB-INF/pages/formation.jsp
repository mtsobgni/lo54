<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Bike
  Date: 02/05/2018
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <jsp:include page="enTete.jsp" />
    <title> Formation</title>

</head>
<body class="home">
<jsp:include page="header.jsp" />
<br>
<br>

<div class="jumbotron top-space">
    <div class="container">
        <br>
        <br>
      <!--  <div  > -->
        <form method="POST" action="search" >
            <fieldset class="recherche_p" >
                <legend>Filtrer</legend>

                       <div class="row">
                           <div class="col-sm-8">
                               <div class="form-group">
                                   <div class="input-group">
                                           <input id="keyword" type="text" placeholder="recherche" name="keyword" class="form-control left-rounded">
                                       <div class="input-group-btn">
                                           <button type="submit" id="search" class="btn btn-inverse right-rounded">Chercher</button>
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
                                   <c:forEach items="${ liste }" var="location" varStatus="status">
                                       <option> <c:out value="${ location.city }" /></option>
                                   </c:forEach>
                               </select>
                               <i class="icon icon-search"></i>
                           </div>
                       </div>

        </fieldset>
    </form>
        <c:set var="date" value="" scope="page" />
        <c:set var="lieu" value="" scope="page" />
        <c:choose>
            <c:when test="${ empty list }">Du texte</c:when>
            <c:otherwise>
                <h2>Inscrivez vouz et commencez à suivre un cours</h2>
                <h3> Nos Formations</h3>
        <form method="post" action="ServletSession">
            <div id="lo" class="w3-container">
                <table style="width:750px" class="w3-table-all w3-hoverable">
                    <thead>
                    <tr class="w3-light-grey">
                        <th>Code</th>
                        <th>Intitulé de la formation</th>
                        <th>S'inscrire à une session</th>
                    </tr>
                    </thead>
                    <c:forEach items="${ list }" var="course" varStatus="status">
                    <tr>
                        <td><c:out value="${ course.code }" /></td>
                        <td><c:out value="${ course.title }" /></td>

                        <td><a href="ServletSession?code=${ course.code }&titre=${ course.title }&date=${ date }&lieu${ lieu }">S'inscrire à une session </a></td>
                    </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
        </div>
        </form>
</div>
</div>

<jsp:include page="footer.jsp" />

<script src="assets/js/recherche.js">   </script>
</body>
</html>
