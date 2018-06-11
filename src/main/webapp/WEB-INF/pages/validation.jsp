<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Bike
  Date: 07/06/2018
  Time: 08:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <jsp:include page="enTete.jsp" />
    <title>Validation</title>
</head>
<body class="home">
<jsp:include page="header.jsp" />
<br>
<br>
<div class="jumbotron top-space">
    <div class="container">
<c:choose>
    <c:when test="${ verif==true }">
        <form method="post" action="/lo54/formation">
            <div >
                <h2>Inscription Réussi</h2>
                <h3>Connectez vous à votre espace pour consulter la liste de vos formation</h3>
            </div>
        <button type="button" id="butforma" name="butforma">Inscrivez vous à un autre cours</button>
        </form>
    </c:when>

    <c:otherwise>

    </c:otherwise>
</c:choose>
</div>
</div>
<jsp:include page="footer.jsp" />

</body>
</html>



