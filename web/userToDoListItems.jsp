<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 29/03/2016
  Time: 02:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="il.ac.hit.model.Task"
         import="java.util.Collections" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<html lang="he">

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


<section class="container">
    <section class="login-form">
        <h2>Hello, ${userName}</h2>
        <form method="post" action="/controller/addTask" role="login">
            <img src="../images/logo.png" class="img-responsive"/>
            <input type="text" name="taskInput" placeholder="Add a task" required class="form-control input-lg"/>
            <button type="submit" name="login" class="btn bt8n-lg btn-primary btn-block">Add</button>

            <div style="color: #FF0000;">${userMessage}</div>
            <table class="table table-bordered">
                <tr>
                    <th align=left>Description</th>
                </tr>

                <%--"<td>" + "<button type=\"button\"  action="/controller/editTask"  name=\"btnEdit\" class=\"btn bt8n-lg btn-info btn-block\">Edit</button>" +--%>
                <%


                    String name = (String) request.getServletContext( ).getAttribute("userName");
                    String taskID = (String) request.getServletContext( ).getAttribute("taskID");
                    List<Task> tasksList = (List<Task>) request.getServletContext( ).getAttribute("tasksList");
                    Collections.reverse(tasksList);

                    Iterator<Task> iterator;
                    if (tasksList != null) {
                        iterator = tasksList.iterator( );
                        while (iterator.hasNext( )) {
                            Task task = (Task) iterator.next( );

                %>
                <label id="taskID"><%out.print(task.getDescription( )); %></label>

                <span id="result1"> </span>
                <input type="button" id="btnEdit" value="edit" class="btn bt8n-lg btn-info btn-block">

                <script type="text/javascript">
                    $(document).ready(function () {
                        $('#btnEdit').click(function () {
                            var task = $('#taskID').val();
                            print(task);
                            $.ajax({
                                type: 'POST',
                                data: {taskId: taskId},
                                url: '/controller/editTask',
                                success: function (result) {
                                    $('#result1').html(result);
                                }
                            });
                        });
                    });
                </script>

                <%
                        }
                    } else {
                        out.print("<td>" + null + "</td>");
                        out.print("<td>" + null + "</td>");
                        out.print("<td>" + null + "</td></tr>");
                    }

                %>
            </table>
        </form>
    </section>
</section>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>

</body>

<script type="text/javascript">
    function fnc() {
        document.getElementById("atext").innerHTML = "tested";
        action = "/controller/editTask";
    }
</script>

</html>



