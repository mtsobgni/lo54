<%--
  Created by IntelliJ IDEA.
  User: Bike
  Date: 20/05/2018
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="enTete.jsp" />
    <title> Accueil Formation</title>

</head>
<body class="home">

<jsp:include page="header.jsp" />

<header id="head">
    <div class="container">
        <div class="row">
            <h1 class="lead">MOOC est une plate-forme d'etudes en ligne spécialisé dans plusieurs domaines</h1>
            <p><a class="btn btn-default btn-lg" role="button">MORE INFO</a> <a href="/lo54/formation" class="btn btn-action btn-lg" role="button">Découvrir nos formations</a></p>
        </div>
    </div>
</header>
<!-- /Header -->

<!-- Intro -->


<div class="container text-center">
    <br> <br>
    <h2 class="thin">Parmis les meilleures en FRANCE</h2>
    <p class="text-muted">
        Vous offre les meilleures cours aussi bien theoriques que pratiques
        Présent dans plusieurs région de la france
    </p>
</div>
<!-- /Intro-->

<!-- Highlights - jumbotron -->
<div class="jumbotron top-space">
    <div class="container">

        <h3 class="text-center thin">Nos meilleurs formations</h3>

        <div class="row">
            <div class="col-md-3 col-sm-6 highlight">
                <div class="h-caption"><h4><i class="fa fa-cogs fa-5"></i> Programmation</h4></div>
                <div class="h-body text-center">
                    <p> Etudes de plusieurs langage de programmation orienté objet </p>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 highlight">
                <div class="h-caption"><h4><i class="fa fa-flash fa-5"></i>Anglais</h4></div>
                <div class="h-body text-center">
                    <p> Elaborez pour l'obtention à la fin de la formation d'un test internationale d'anglais ( Bulats , TOEIC ) </p>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 highlight">
                <div class="h-caption"><h4><i class="fa fa-heart fa-5"></i>Intelligence artificielle</h4></div>
                <div class="h-body text-center">
                    <p> Introduction à la notion d'intelligence artificielle et qielques applications</p>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 highlight">
                <div class="h-caption"><h4><i class="fa fa-smile-o fa-5"></i>Réseaux</h4></div>
                <div class="h-body text-center">
                    <p>Interconnexion des réseaux </p>
                </div>
            </div>
        </div> <!-- /row  -->

    </div>
</div>
<!-- /Highlights -->

<!-- container -->


<!-- Social links. @TODO: replace by link/instructions in template -->
<section id="social">
    <div class="container">
        <div class="wrapper clearfix">
            <!-- AddThis Button BEGIN -->
            <div class="addthis_toolbox addthis_default_style">
                <a class="addthis_button_facebook_like" fb:like:layout="button_count"></a>
                <a class="addthis_button_tweet"></a>
                <a class="addthis_button_linkedin_counter"></a>
                <a class="addthis_button_google_plusone" g:plusone:size="medium"></a>
            </div>
            <!-- AddThis Button END -->
        </div>
    </div>
</section>
<!-- /social links -->


<jsp:include page="footer.jsp" />

</body>
</html>
