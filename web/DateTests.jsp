<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 20/03/2016
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>JQuery Demo</title>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css"/>
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>


    <style>
        .datepicker {

        }
    </style>

    <script>
        $(function () {
            $(".datepicker").datepicker({dateFormat: "dd/mm/yy"});
            $(".datepicker").datepicker({minDate: 0});
            $(".datepicker").datepicker();
        });
    </script>

</head>
<body>

<p>Task Date: <input type="text" class="datepicker"/></p>


</body>
</html>
