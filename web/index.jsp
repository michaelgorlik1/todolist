<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 14/03/2016
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    out.print("<table>");
    for(int row=1; row<=10; row++)
    {
      out.print("<tr>");
      for(int col=1; col<=10; col++)
      {
        out.print("<td>"+(col*row)+"</td>");
      }
      out.print("</tr>");
    }
    out.print("</table>");
  %>
  </body>
</html>
