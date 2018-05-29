<%@ page import="fr.utbm.lo54.entity.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.ResultSetMetaData" %>
<%@ page import="java.util.ListIterator" %>
<%@ page import="fr.utbm.lo54.entity.CourseSession" %>
<%@ page import="fr.utbm.lo54.entity.Location" %>
<%--
  Created by IntelliJ IDEA.
  User: Bike
  Date: 02/05/2018
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"    content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author"      content="Sergey Pozhilov (GetTemplate.com)">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title> Formation</title>

    <link rel="shortcut icon" href="assets/images/gt_favicon.png">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/font-awesome.min.css">

    <!-- Custom styles for our template -->
    <link rel="stylesheet" href="assets/css/bootstrap-theme.css" media="screen" >
    <link rel="stylesheet" href="assets/css/main.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="//code.jquery.com/jquery-1.10.2.js"
            type="text/javascript"></script>
    <script src="assets/js/html5shiv.js"></script>
    <script src="assets/js/respond.min.js"></script>
    <![endif]-->
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
        <form method="POST" >
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
                           <input id="date" type="date" name="date" style="align-content: center">
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

                <!--      </form> -->




          <!-- </div> -->
        </fieldset>
    </form>
<%List<Course> lst;
    lst = (List<Course>) request.getAttribute("list");
    %>
        <style type='text/css'>

            /* Fond du gadget de la barre de recherche */
            .recherche_p {
                background-color: #eeeeee;   /* Couleur de fond */
                border-style: solid;   /* Style de la bordure  */
                border-width: 1px;   /* Epaisseur de la bordure  */
                border-color: #dddddd;   /* Couleur de la bordure  */
                padding: 10px 10px 10px 10px;   /* Espace entre les bords et le contenu : haut droite bas gauche  */
            }

            /* Champ de saisie */
            #searchthis #search {
                background-color: #ffffff;   /* Couleur de fond */
                border-style: solid;   /* Style de la bordure  */
                border-width: 1px;   /* Epaisseur de la bordure  */
                border-color: #dddddd;   /* Couleur de la bordure  */
                padding: 5px 10px 5px 10px;   /* Espace entre les bords et le contenu : haut droite bas gauche  */
                width: 98.5%;   /* Permet d'ajuster la largeur du champ de saisie à 100% */
                box-sizing: border-box;   /* Important */
                font-family: Lato;   /* Police du texte */
                font-size: 12px;   /* Taille de la police du texte */
                font-weight: normal;   /* Graisse du texte : normal = normal ; bold = gras */
                letter-spacing: 1px;   /* Espacement des caractères */
            }

            /* Bouton valider */
            #searchthis #search-btn {
                background-color: #E8B960;   /* Couleur de fond */
                border-style: solid;   /* Style de la bordure  */
                border-width: 1px;   /* Epaisseur de la bordure  */
                border-color: #E8B960;   /* Couleur de la bordure  */
                padding: 5px 10px 5px 10px;   /* Espace entre les bords et le contenu : haut droite bas gauche  */
                width: 98.5%;   /* Permet d'ajuster la largeur du champ de saisie à 100% */
                box-sizing: border-box;   /* Important */
                font-family: PT sans;   /* Police du texte */
                font-size: 13px;   /* Taille de la police du texte */
                font-weight: normal;   /* Graisse du texte : normal = normal ; bold = gras */
                letter-spacing: 2px;   /* Espacement des caractères */
                margin: 10px 0 0 0;   /* Espace autour du bouton : haut droite bas gauche  */
                text-transform: uppercase;   /* Transforme le texte en majuscules */
                color: #ffffff;   /* Couleur du texte */
            }

            /* Bouton valider quand survolé par la souris */
            #searchthis #search-btn:hover {
                background-color: #ffffff;   /* Couleur de fond */
                color: #E8B960;   /* Couleur du texte */
                cursor: pointer;   /* Apparence du curseur comme pour un lien */
            }

        </style>
        <% if(lst.isEmpty()){

        }
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
                    ListIterator<Course> li = lst.listIterator();
                    while (li.hasNext())
                    {
                        Course c=li.next();
                %>
                <tr>
                    <td><%= c.getCode()%></td>
                    <td><%= c.getTitle()%></td>
                    <!--  <td> <button type="submit" id="detail" name="detail"> S'inscrire à une session </button> </td>-->
                   <td><a href="ServletSession?code=<%=c.getCode()%>&titre=<%=c.getTitle()%>&date=<%=date%>&lieu=<%=lieu%>">S'inscrire à une session </a></td>
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

<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="assets/js/headroom.min.js"></script>
<script src="assets/js/jQuery.headroom.min.js"></script>
<script src="assets/js/template.js"></script>
<script src="assets/js/recherche.js">   </script>
</body>
</html>






