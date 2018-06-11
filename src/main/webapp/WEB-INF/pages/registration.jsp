<%@ page import="fr.utbm.lo54.entity.CourseSession" %>
<%@ page import="fr.utbm.lo54.repository.CourseSessionDao" %>
<%@ page import="fr.utbm.lo54.tools.Helper" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en" class="position-relative"  style="min-height: 100%">
<head>
    <jsp:include page="head.jsp"/>
    <script>
        function validateForm() {
            var firstname = document.forms["myForm"]["firstname"].value;
            if (firstname == "") {
                alert("Prénom invalide");
                return false;
            }
            var lastname = document.forms["myForm"]["lastname"].value;
            if (lastname == "") {
                alert("Nom invalide");
                return false;
            }
            var address = document.forms["myForm"]["address"].value;
            if (address == "") {
                alert("Adresse invalide");
                return false;
            }
            var phone = document.forms["myForm"]["phone"].value;
            if (phone == "") {
                alert("Phone invalide");
                return false;
            }
            var email = document.forms["myForm"]["email"].value;
            if (email == "") {
                alert("Email invalide");
                return false;
            }

            alter("Votre inscription a été bien enregistré");
        }
    </script>
    <title> Inscription </title>
</head>
<body>
<jsp:include page="header.jsp"/>

<main role="main" style="margin-bottom: 150px;">
    <div class="text-center container mt-5">
        <div class="mt-5">
            <%
                CourseSessionDao courseSessionDao = new CourseSessionDao();
                Integer idSession = Integer.parseInt(request.getParameter("idSession"));
                CourseSession courseSession = courseSessionDao.getCourseSession(idSession);
            %>
            <p class="font-weight-bold"><%= courseSession.getCode().getCode() %> - <%= courseSession.getCode().getTitle() %></p>
            <p><%= Helper.formatFrenchDate(courseSession.getStartDate()) %> - <%= Helper.formatFrenchDate(courseSession.getEndDate()) %></p>
            <p>à <%= courseSession.getId().getCity() %></p>
        </div>
        <form name="myForm" method="post" action="registration" onsubmit="return validateForm()">
            <input type="hidden" name="idSession" value=<%= request.getParameter("idSession") %>>
            <label for="firstname"> Prénom </label>
            <input type="text" name="firstname" id="firstname" class="form-control">
            Nom :<br>
            <input type="text" name="lastname" name="lastname" class="form-control">
            Adresse :<br>
            <input type="text" name="address" name="address" class="form-control">
            Phone :<br>
            <input type="tel" name="phone" name="phone" class="form-control">
            Email :<br>
            <input type="email" name="email" name="email" class="form-control">
            <hr class="mb-4">
            <button type="submit" class="btn btn-primary btn-lg btn-block"> Ajouter </button>
        </form>
    </div>
</main>

<jsp:include page="footer.jsp"/>
</body>
</html>