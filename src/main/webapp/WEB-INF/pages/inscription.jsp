<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Bike
  Date: 28/05/2018
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <jsp:include page="enTete.jsp" />
    <title>Register</title>
</head>
<body class="home">
<jsp:include page="header.jsp" />
<br>
<br>

<div class="jumbotron top-space">
    <div class="container">
        <br>
        <div id="echec" class="container" name="echec"  style="visibility: ${visibility}; display: ${display}">
            <h2>Echec de l'inscription</h2>
            <h3>Votre  nom et prenom ou votre email existe deja. Veuillez modifier ces informations et vous inscrire de nouveau </h3>
        </div>
        <h2> ${titre}</h2>
        <!--<h2> <%= request.getAttribute("titre")%></h2> -->
        <c:choose>
        <c:when test="${ empty listSession }">
            <div class="panel panel-default">

                <div class="panel-heading">

                    <h3 class="panel-title">Formulaire d'inscription</h3>
                </div>
                <div class="panel-body" style="background-color: #F7F5F4">
                    <div>
                        <form role="form" name="form" action="" method="post">
                            <div class="form-group">
                                <label for="lname">LastName</label>
                                <input type="text" name="lname" class="form-control" id="lname" placeholder="Dairou" required>
                            </div>
                                <input type="hidden" name="idsession" value="${idsession}" id="idsession" required>
                            <div class="form-group">
                                <label for="fname">FirstName</label>
                                <input type="text" name="fname" class="form-control" id="fname" placeholder="ABBA" required>
                            </div>
                            <div class="form-group">
                                <label for="email">Adresse email</label>
                                <input type="email" name="email" class="form-control" id="email" placeholder="Adresse email" required>
                            </div>
                            <div class="form-group">
                                <label for="address">Address</label>
                                <input type="text" name="address" class="form-control" id="address" placeholder="3 Rue Gaston Defferre, 90000 BELFORT" required>
                            </div>
                            <div class="form-group">
                                <label for="tel">Telephone</label>
                                <input type="text" name="tel" class="form-control" id="tel" placeholder="Mot de passe" required>
                            </div>
                            <button type="submit" class="btn btn-primary"><i class="icon icon-check icon-lg"></i> Valider</button>
                            <button type="reset" class="btn btn-inverse"><i class="icon icon-times icon-lg"></i> Annuler</button>
                        </form>
                    </div>
                </div>
            </div>
        </c:when>
        <c:otherwise>

            </c:otherwise>
            </c:choose>
        </div>

    </div>
</div>

<jsp:include page="footer.jsp" />

</body>
</html>
