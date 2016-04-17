<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 28/03/2016
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>
    <link href="http://fonts.googleapis.com/css?family=Lato:100italic,100,300italic,300,400italic,400,700italic,700,900italic,900"
          rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="../css/styles.css"/>

    <style>
        body {
            background: url(../images/404.jpg) no-repeat center center fixed;
            -webkit-background-size: auto;
            -moz-background-size: auto;
            -o-background-size: auto;
            background-size: auto;
        }

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

        @media only screen and (max-width: 1024px) {
            .collapsing, .in {
                background-color: #f7f7f7;
            }

            .collapsing ul li a, .in ul li a {
                color: #555 !important;
            }

            .collapsing ul li a:hover, .in ul li a:hover {
                color: #f1f1f1 !important;
            }

            body {
                background-color: #3CB4A7;
                background-image: none;
            }
        }

    </style>
</head>

<body>
<jsp:include page="/menu.jsp"/>

</body>
</html>
