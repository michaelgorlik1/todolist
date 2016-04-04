<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 17/03/2016
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=1,initial-scale=1,user-scalable=1"/>
    <title>The Todo List</title>

    <link href="http://fonts.googleapis.com/css?family=Lato:100italic,100,300italic,300,400italic,400,700italic,700,900italic,900"
          rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="../css/styles.css"/>
    <style>
        .navbar {
            background-color: #28a0a1;
        }

        .navbar-default .navbar-nav > li > a, .navbar-default .navbar-brand {
            color: #f1f1f1;
        }

        .navbar-default .navbar-nav > li > a:hover,
        .navbar-default .navbar-nav > li > a:focus {
            color: #f1f1f1;
            background-color: #b27677;
        }

        @media only screen and (max-width: 766px) {
            .collapsing, .in {
                background-color: #f7f7f7;
            }

            .collapsing ul li a, .in ul li a {
                color: #555 !important;
            }

            .collapsing ul li a:hover, .in ul li a:hover {
                color: #f1f1f1 !important;
            }
        }
    </style>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">The ToDo list</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="#">About</a></li>
                <li><a href="#">Info</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/register.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="/index.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
        </div>
    </div>
</nav>

<section class="container">
    <section class="login-form">
        <form method="post" action="/controller/login" role="login">
            <img src="../images/logo.png" class="img-responsive" alt=""/>
            <input type="text" name="userName" placeholder="User Name" required class="form-control input-lg"/>
            <input type="password" name="password" placeholder="Password" required class="form-control input-lg"/>
            <button type="submit" name="login" class="btn btn-lg btn-primary btn-block">Sign in</button>
            <div style="color: #FF0000;">${userMessage}</div>
            <div>
                <a href="/register.jsp">Create account</a>
            </div>
        </form>
    </section>
</section>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
