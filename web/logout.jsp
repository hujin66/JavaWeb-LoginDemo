<%--
  Created by IntelliJ IDEA.
  User: foyou
  Date: 2020/1/23
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录测试</title>
</head>
<body>
<%
    session.setAttribute("user",null);
    response.sendRedirect("login.jsp");
%>
</body>
</html>
