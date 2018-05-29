<%@ page import="fr.utbm.lo54.entity.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ListIterator" %><%--
  Created by IntelliJ IDEA.
  User: Bike
  Date: 26/05/2018
  Time: 08:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="width:750px" class="w3-table-all w3-hoverable">
    <thead>
    <tr class="w3-light-grey">
        <th>Code</th>
        <th>Intitulé de la formation</th>
        <th>S'inscrire à une session</th>
    </tr>
    </thead>
    <%
        List<Course> lst;
        lst = (List<Course>) request.getAttribute("list");
        ListIterator<Course> li = lst.listIterator();
        while (li.hasNext())
        {
            Course c=li.next();
    %>
    <tr>
        <td><%= c.getCode()%></td>
        <td><%= c.getTitle()%></td>
        <td><a href="ServletSession?code=<%=c.getCode()%>">S'inscrire à une session </a></td>
    </tr>
    <%}%>
</table>
</div>
</body>
</html>
