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
    <meta charset="utf-8">
    <meta name="viewport"    content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author"      content="Sergey Pozhilov (GetTemplate.com)">

    <title> Accueil formation</title>

    <link rel="shortcut icon" href="assets/images/gt_favicon.png">

    <link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/font-awesome.min.css">

    <!-- Custom styles for our template -->
    <link rel="stylesheet" href="assets/css/bootstrap-theme.css" media="screen" >
    <link rel="stylesheet" href="assets/css/main.css">



    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="assets/js/html5shiv.js"></script>
    <script src="assets/js/respond.min.js"></script>
    <![endif]-->
</head>
<body class="home">
<jsp:include page="header.jsp" />
<!-- Fixed navbar -->

<!-- /.navbar -->

<!-- Header -->
<header id="head">
    <div class="container">
        <div class="row">
            <h1 class="lead">MOOC est une plate-forme d'etudes en ligne spécialisé dans plusieurs domaines</h1>
            <p><a class="btn btn-default btn-lg" role="button">MORE INFO</a> <a class="btn btn-action btn-lg" role="button">Découvrir nos formations</a></p>
        </div>
    </div>
</header>
<!-- /Header -->

<!-- Intro -->


<div class="container text-center">
    <br> <br>
    <h2 class="thin">Parmis les meilleures en FRANCE</h2>
    <p class="text-muted">
        The difference between involvement and commitment is like an eggs-and-ham breakfast:<br>
        the chicken was involved; the pig was committed.
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

<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="assets/js/headroom.min.js"></script>
<script src="assets/js/jQuery.headroom.min.js"></script>
<script src="assets/js/template.js"></script>
</body>
</html>
