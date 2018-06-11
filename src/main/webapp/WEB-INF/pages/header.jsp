<%--
  Created by IntelliJ IDEA.
  User: Bike
  Date: 20/05/2018
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="navbar navbar-inverse navbar-fixed-top headroom" >
    <div class="container">
        <div class="navbar-header">
            <!-- Button for smallest screens -->
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
            <a class="navbar-brand" href="/home"><img src="assets/images/logo.jpg" alt="Progressus HTML5 template"></a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav pull-right">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="about.html">About</a></li>
                <li class="dropdown">
                    <a href=# class="dropdown-toggle" data-toggle="dropdown"> Nos Formations <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="">Tarifs</a></li>
                        <li class="active"><a href="/lo54/formation">Formations</a></li>
                    </ul>
                </li>
                <li><a href="contact.html">Contact</a></li>
                <li><a class="btn" href="signin.html">SIGN IN / SIGN UP</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>