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
            <div class="row mb-5">
                <form method="POST" action="courses" class="w-100">
                    <div class="form-group row">
                        <div class="col-md-12 mb-3">
                            <c:choose>
                                <c:when test="${ empty keyword }">
                                    <input id="s" type="text" placeholder="Recherche..." name="keyWord" class="form-control">
                                </c:when>
                                <c:otherwise>
                                    <input id="s" value="${keyword}" type="text" placeholder="Recherche..." name="keyWord" class="form-control">
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-md-6 mb-3">
                            <input type="date" name="date" class="form-control">
                        </div>
                        <div class="col-md-6 mb-3">
                             <select name="location" class="form-control">
                                  <option value="">Lieu</option>
                                  <c:forEach items="${ listLocation }" var="listLocation" varStatus="status">
                                   <option value="${listLocation.id}"> ${ listLocation.city }</option>
                                 </c:forEach>
                        </select>
                        </div>
                    </div>
                    <button type="submit" id="rec" class="btn btn-primary btn-lg btn-block">
                        Chercher
                    </button>
                </form>
            </div>
            <c:choose>
            <c:when test="${ empty listCourse }">
            </c:when>
            <c:otherwise>
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
                        <c:forEach items="${ listCourse }" var="course" varStatus="status">
                            <tr>
                                <td><c:out value="${ course.code }" /></td>
                                <td><c:out value="${ course.title }" /></td>

                                <td><a href="courseSessions?code=${course.code}">S'inscrire</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:otherwise>
        </c:choose>
        </div>
    </section>
</main>

<jsp:include page="footer.jsp"/>
</body>
</html>
