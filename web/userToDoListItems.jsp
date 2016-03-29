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
    <title>Title</title>
</head>
<body>

<jsp:useBean id="name" scope="request" class="il.ac.hit.model.User"/>
User name :
<jsp:setProperty name="name" property="name"/>
</body>
</html>
