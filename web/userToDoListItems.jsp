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

            <%--<table class="table table-bordered">--%>
            <%--<tr>--%>
            <%--<th align=left>Description</th>--%>
            <%--</tr>--%>

            <%--&lt;%&ndash;"<td>" + "<button type=\"button\"  action="/controller/editTask"  name=\"btnEdit\" class=\"btn bt8n-lg btn-info btn-block\">Edit</button>" +&ndash;%&gt;--%>
            <%--<%--%>


            <%--String name = (String) request.getServletContext( ).getAttribute("userName");--%>
            <%--String taskID = (String) request.getServletContext( ).getAttribute("taskID");--%>
            <%--List<Task> tasksList = (List<Task>) request.getServletContext( ).getAttribute("tasksList");--%>
            <%--Collections.reverse(tasksList);--%>

            <%--Iterator<Task> iterator;--%>
            <%--if (tasksList != null) {--%>
            <%--iterator = tasksList.iterator( );--%>
            <%--while (iterator.hasNext( )) {--%>
            <%--Task task = (Task) iterator.next( );--%>

            <%--%>--%>
            <%--<label id="taskID"><%out.print(task.getDescription( )); %></label>--%>

            <%--<span id="result1"> </span>--%>
            <%--<input type="button" id="btnEdit" value="edit" class="btn bt8n-lg btn-info btn-block">--%>

            <%--<script type="text/javascript">--%>
            <%--$(document).ready(function () {--%>
            <%--$('#btnEdit').click(function () {--%>
            <%--var task = $('#taskID').val();--%>
            <%--print(task);--%>
            <%--$.ajax({--%>
            <%--type: 'POST',--%>
            <%--data: {taskId: taskId},--%>
            <%--url: '/controller/editTask',--%>
            <%--success: function (result) {--%>
            <%--$('#result1').html(result);--%>
            <%--}--%>
            <%--});--%>
            <%--});--%>
            <%--});--%>
            <%--</script>--%>

            <%--<%--%>
            <%--}--%>
            <%--} else {--%>
            <%--out.print("<td>" + null + "</td>");--%>
            <%--out.print("<td>" + null + "</td>");--%>
            <%--out.print("<td>" + null + "</td></tr>");--%>
            <%--}--%>

            <%--%>--%>
            <%--</table>--%>
        </form>

        <table class="table table-bordered" id="tabledata">
            <tr>
                <th align="center">Description</th>
                <th align="center">Action</th>
            </tr>

            <%
                List<Task> tasksList = (List<Task>) request.getServletContext().getAttribute("tasksList");
                Collections.reverse(tasksList);

                Iterator<Task> iterator;
                if (tasksList != null)
                {
                    iterator = tasksList.iterator();
                    while (iterator.hasNext())
                    {
                        Task task = (Task) iterator.next();
            %>
            <tr>
                <td>
                    <label id="<%=task.getTaskID()%>"><%out.print(task.getDescription()); %></label>
                </td>
                <td>
                    <button id="<%=task.getTaskID()%>" class="btnDelete">Delete</button>
                    <button id="<%=task.getTaskID()%>" class="btnEdit">Edit</button>
                </td>
                <div id="somediv"></div>
            </tr>
            <%
                    }
                }
            %>
        </table>


        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th class="">Description</th>
                <th class="">Action</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td style="text-align:center;" class="">1</td>
                <td style="text-align:center;">
                    <button class="btn btn-success" data-toggle="modal" data-target="#myModal" contenteditable="false">
                        Edit
                    </button>
                </td>

                    <%
                List<Task> tasksList2 = (List<Task>) request.getServletContext().getAttribute("tasksList");
                Collections.reverse(tasksList);

                Iterator<Task> iterator2;
                if (tasksList != null)
                {
                    iterator2 = tasksList2.iterator();
                    while (iterator2.hasNext())
                    {
                        Task task = (Task) iterator2.next();
            %>
            <tr>
                <td style="text-align:center;"><%out.print(task.getDescription());%></td>
                <td>
                    <button id="<%=task.getTaskID()%>" class="btnDelete">Delete</button>
                    <button id="<%=task.getTaskID()%>" class="btn btn-success" data-toggle="modal"
                            data-target="#myModal" contenteditable="false">Edit
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


<script type="text/javascript">

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
            formGroup.append('<input class="form-control"  name="' + columnHeader + i + '" id="' + columnHeader + i + '" value="' + columnValues + '" />');
            formGroup.append('<input type="hidden" class="form-control"  name="taskID" id="' + columnHeader + i + '" value="' + idk + '" />');
            modalForm.append(formGroup);
        });
        modalBody.append(modalForm);
        $('.modal-body').html(modalBody);
    });
    $('.modal-footer .btn-primary').click(function () {
        $('form[name="modalForm"]').submit();
    });
</script>


<script type="text/javascript">
    $(document).ready(function () {
        var parent = $(this).parent().parent();
        $('.btnDelete').click(function () {
            $.ajax(
                    removeFromDB(this.id));
            parent.fadeOut('slow', function () {
                        $(this).remove();
                    }
            );
        });

        function removeFromDB(taskID) {
            $.post(
                    "removeTask",
                    {taskID: taskID}
            );
        };

        $('.btnEdit').click(function () {
            $.ajax(editFromDB(this.id));
            parent.fadeOut('slow', function () {
                        $(this).remove();
                    }
            );
        });
        function editFromDB(taskID) {
            $.post(
                    "editTask",
                    {taskID: taskID}
            );
        };


    });
    /*new*/


    /*new end*/


</script>
</html>



