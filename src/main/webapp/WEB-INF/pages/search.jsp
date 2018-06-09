<%@ page import="fr.utbm.lo54.entity.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.ResultSetMetaData" %>
<%@ page import="java.util.ListIterator" %>
<%@ page import="fr.utbm.lo54.entity.CourseSession" %>
<%@ page import="fr.utbm.lo54.entity.Location" %>
<%--
  Created by IntelliJ IDEA.
  User: Bike
  Date: 30/05/2018
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <jsp:include page="head.jsp" />
    <title>Search</title>
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
        <% String keyword= (String) request.getAttribute("keyword");%>
        <form method="POST"  >
            <fieldset class="recherche_p" >
                <legend>Filtrer</legend>
                <!--    <form role="search" >-->
                <div class="row">
                    <div class="col-sm-8">
                        <div class="form-group">
                            <div class="input-group">
                                <% if(keyword==null){
                                %>
                                <input id="s"  type="text" placeholder="recherche" name="s" class="form-control left-rounded">
                                <%}else{ %>
                                <input id="s" value="<%=request.getAttribute("keyword")%>" type="text" placeholder="recherche" name="s" class="form-control left-rounded">
                                <% } %>
                                <div class="input-group-btn">
                                    <button type="submit" id="rec" class="btn btn-inverse right-rounded">Chercher</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <input id="date"  type="date" name="date" style="align-content: center">
                </div>
                <div class="form-group">
                    <div class="icon-addon addon-md">
                        <select name="lieu" class="form-control" style="width: 250px">
                            <option value="">Filtrer par lieu</option>
                            <%
                                List<Location> list;
                                list = (List<Location>) request.getAttribute("liste");
                                String lieu = (String) request.getAttribute("lieu");
                                String date = (String) request.getAttribute("date");
                                ListIterator<Location> ite = list.listIterator();
                                while (ite.hasNext())
                                {
                                    Location d=ite.next();
                            %>
                            <option><%= d.getCity()%></option>
                            <%}%>
                        </select>
                        <i class="icon icon-search"></i>
                    </div>
                </div>

            </fieldset>
        </form>
        <% List<CourseSession> lst;
            lst = (List<CourseSession>) request.getAttribute("list");

         if(lst.isEmpty()){
             %>
             <div>
              <h2>Aucun résultat pour la recherche demander</h2>
                     </div>
       <% }
        else {
        %>
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
                    <%
                        ListIterator<CourseSession> li = lst.listIterator();
                        while (li.hasNext())
                        {
                            CourseSession c=li.next();
                    %>
                    <tr>
                        <td><%= c.getCode().getCode()%></td>
                        <td><%= c.getCode().getTitle()%></td>
                        <!--  <td> <button type="submit" id="detail" name="detail"> S'inscrire à une session </button> </td>-->
                        <td><a href="ServletSession?code=<%=c.getCode().getCode()%>&titre=<%=c.getCode().getTitle()%>&date=<%=date%>&lieu=<%=lieu%>">S'inscrire à une session </a></td>
                    </tr>
                    <%}%>
                </table>
            </div>
        </form>
        <div class="container">


        </div><!-- /.container -->

        <%    }%>
    </div>
</div>

<jsp:include page="footer.jsp" />

<script src="assets/js/recherche.js">   </script>
</body>
</html>









