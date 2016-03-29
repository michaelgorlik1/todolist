<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 29/03/2016
  Time: 02:30
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

</head>
<body>
<section class="container">
    <section class="login-form">
        <form method="post" action="/controller/addTask" role="login">
            <img src="../images/logo.png" class="img-responsive" alt=""/>
            <input type="text" name="taskText" placeholder="Add a task" required class="form-control input-lg"/>
            <button type="submit" name="login" class="btn bt8n-lg btn-primary btn-block">Add</button>

            <div style="color: #FF0000;">${userMessage}</div>
        </form>
    </section>
</section>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>

</body>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>

</html>



