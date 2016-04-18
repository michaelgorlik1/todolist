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


<%--<jsp:include page="/menu.jsp"/>--%>
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
                <li><a href="controller/logout"><span class="glyphicon glyphicon-log-out"></span>Log Out</a></li>
            </ul>
        </div>
    </div>
</nav>

<section class="container">
    <section class="login-form">
        <%--<%--%>
        <%--String test = request.getParameter("userName");--%>
        <%--if(test == null)--%>
        <%--{--%>
        <%--request.getServletContext().setAttribute("userMessage", "Please login or register");--%>
        <%--response.sendRedirect("/index.jsp");--%>
        <%--}--%>
        <%--%>--%>


        <h2>Hello, ${userName}</h2>

        <form method="post" action="/controller/addTask" role="login">
            <img src="../images/logo.png" class="img-responsive"/>
            <input type="text" name="taskInput" placeholder="Add a task" required class="form-control input-lg"/>

            <button type="submit" name="login" value="AddTask" class="btn btn-lg btn-primary btn-block">Add</button>

            <%--<div style="color: #FF0000;">${userMessage}</div>--%>

            <table class="table table-bordered">
                <thead>

                <%
                    List<Task> tasksList = (List<Task>) request.getServletContext( ).getAttribute("tasksList");
                    Iterator<Task> iterator;
                    if (tasksList != null) {
                %>

                <tr>
                    <th class="">Description</th>
                    <th class="">Action</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                        <%
                    Collections.reverse(tasksList);
                    iterator = tasksList.iterator();
                    while (iterator.hasNext())
                    {
                        Task task = (Task) iterator.next();
                %>

                <tr>
                    <td style="text-align:center;"><%out.print(task.getDescription( ));%></td>
                    <td>

                        <button type="button" id="<%=task.getTaskID()%>" class="btn btn-success" data-toggle="modal"
                                data-target="#myModal" contenteditable="false">Edit
                        </button>
                        <button type="button" id="<%=task.getTaskID()%>" contenteditable="false"
                                data-target="#deleteTask"
                                class="btn btn-danger">Delete
                        </button>

                    </td>
                </tr>
                <%
                        }
                    }
                %>
                </tr>
                </tbody>

            </table>
        </form>

        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content"></div>
            </div>
            <div class="modal-dialog">
                <div class="modal-content"></div>
            </div>
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true"
                                                                                       class="">×</span><span
                                class="sr-only">Close</span>

                        </button>
                        <h4 class="modal-title" id="myModalLabel">Modal title</h4>

                    </div>
                    <div class="modal-body"></div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>

    </section>
</section>

</body>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

<script type="text/javascript">

    $("form input[type=submit]").click(function () {
        //console.log($(this).val());
        if ($(this).val() !== "AddTask") {
            $('form input[type=text]').each(function () {
                $(this).removeAttr("required");
            });
        }
        $("input[type=submit]", $(this).parents("form")).removeAttr("clicked");
        $(this).attr("clicked", "true");
    });


    $(document).ready(function () {


        $(".btn[data-target='#myModal']").click(function () {

            var columnHeadings = $("thead th").map(function () {
                return $(this).text();
            }).get();
            columnHeadings.pop();
            var columnValues = $(this).parent().siblings().map(function () {
                return $(this).text();
            }).get();
            var modalBody = $('<div id="modalContent"></div>');

            var idk = $(this).attr('id');

            var modalForm = $('<form role="form" name="modalForm" action="/controller/editTask" method="post"></form>');
            $.each(columnHeadings, function (i, columnHeader) {
                var formGroup = $('<div class="form-group"></div>');
                formGroup.append('<label for="' + columnHeader + '">' + columnHeader + '</label>');
                formGroup.append('<input class="form-control"  name="' + columnHeader + '" id="' + columnHeader + i + '" value="' + columnValues + '" />');
                formGroup.append('<input type="hidden" class="form-control"  name="taskID" id="' + columnHeader + i + '" value="' + idk + '" />');
                modalForm.append(formGroup);
            });
            modalBody.append(modalForm);
            $('.modal-body').html(modalBody);
        });
        $('.modal-footer .btn-primary').click(function () {
            $('form[name="modalForm"]').submit();
        });


        $(".btn[data-target='#deleteTask']").click(function () {
            //var id = $(this).parent().parent().attr('id');
            var id = this.id;
            var data = 'id=' + id;
            var parent = $(this).parent().parent();
            $.ajax(
                    {
                        type: "POST",
                        url: "controller/removeTask",
                        data: {"taskID": id, "data": data},
                        cache: false,
                        beforeSend: function () {
                            parent.animate({'backgroundColor': '#fb6c6c'}, 300);
                        },
                        success: function () {
                            parent.fadeOut('slow', function () {
                                $(this).remove();
                            });
                        }
                    });

        });
    })

</script>
</html>



