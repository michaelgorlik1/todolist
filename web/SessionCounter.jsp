<%@ page import="il.ac.hit.model.IToDoListDAO" %>
<%@ page import="il.ac.hit.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 09/05/2016
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session Listener example</title>
</head>
<body>
<%
    IToDoListDAO toDoListDAO = il.ac.hit.model.ToDoListDAO.getInstance( );
    List<User> listUsers = toDoListDAO.getUsersList( );

    // List<String> users = (List<String>)session.getAttribute("users");
    for (int i = 0; null != listUsers && i < listUsers.size( ); i++) {
        out.println("<br/>" + listUsers.get(i));
    }
%>
<%= "<br/>number of sessions is " + ((Set) application.getAttribute("sessions")).size( )  %>

</body>
</html>
