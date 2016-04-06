<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 29/03/2016
  Time: 02:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="il.ac.hit.model.Task"
         import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
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
        <h2>Hello, ${userName}</h2>
        <form method="post" action="/controller/addTask">
            <img src="../images/logo.png" class="img-responsive"/>
            <input type="text" name="taskInput" placeholder="Add a task" required class="form-control input-lg"/>
            <button type="submit" name="login" class="btn bt8n-lg btn-primary btn-block">Add</button>

            <div style="color: #FF0000;">${userMessage}</div>
        </form>
    </section>
</section>
<table class="table table-bordered">
    <tr>
        <th align=left>ID</th>
        <th align=left>Description</th>
        <th align=left>Due date</th>
        <th align=left>Status</th>
    </tr>


    <%
        String name = (String) request.getAttribute("userName");
        List<Task> tasksList = (List<Task>) request.getAttribute("tasksList");
        Iterator<Task> iterator;
        if (tasksList != null)
        {
            iterator = tasksList.iterator();
            while (iterator.hasNext())
            {
                Task task = (Task) iterator.next();


                out.print("<td>" + task.getDescription() + "</td>");
                out.print("<td>" + task.getDate() + "</td>");
                out.print("<td>" + task.getTitle() + "</td></tr>");
            }
        } else
        {
            out.print("<td>" + name + "</td>");
            out.print("<td>" + name + "</td>");
            out.print("<td>" + null + "</td></tr>");
        }
    %>
</table>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>

</body>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>

</html>



