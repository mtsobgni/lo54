<%--
  Created by IntelliJ IDEA.
  User: jlwei
  Date: 2018/6/10
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="head.jsp"/>
    <title>Inscription</title>
</head>
<body>
    <form method="post" action="registration">
        <input type="hidden" name="idSession" value=<%= request.getParameter("idSession") %>>
        Prénom :<br>
        <input type="text" name="firstname">
        Nom :<br>
        <input type="text" name="lastname">
        Adresse :<br>
        <input type="text" name="address">
        Phone :<br>
        <input type="tel" name="phone">
        Email :<br>
        <input type="email" name="email">
        <input type="submit">
    </form>
</body>
</html>
