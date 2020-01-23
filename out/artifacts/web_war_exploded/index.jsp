<%@ page import="com.company.SqlLiteHelper" %>
<%@ page import="com.company.UserObject" %><%--
  Created by IntelliJ IDEA.
  User: foyou
  Date: 2020/1/18
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录测试</title>
</head>
<body>
<%
    //判断登录状态
    UserObject user = (UserObject) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
    } else if (SqlLiteHelper.select(user)) {
        out.print("<p>欢迎：" + user.getUser() + "</p>");
        out.print("<a href=\"logout.jsp\">退出登录</a>");
    } else {
        out.print("<h3> What are you fuck doing ? </h3>");
    }
%>
</body>
</html>
