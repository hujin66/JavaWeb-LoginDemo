<%@ page import="com.company.SqlLiteHelper" %>
<%@ page import="com.company.UserObject" %>
<%@ page import="static com.company.UserUtils.ValidChars" %><%--
  Created by IntelliJ IDEA.
  User: foyou
  Date: 2020/1/20
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<%
    //获取参数
    String user = request.getParameter("user");
    String password = request.getParameter("password");
    //简单判断
    if (ValidChars(user) && ValidChars(password)) {
        //验证用户名密码
        UserObject userObject = new UserObject(user, password);
        if (SqlLiteHelper.select(userObject)) {
            session.setAttribute("user", userObject);
            response.sendRedirect("index.jsp");
        } else {
%>
<h4 style="color: red">
    用户名 或 密码错误,请重新输入！
</h4>
<%
        }
    }
%>
<form action="login.jsp" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="user"></td>
        </tr>
        <tr>
            <td>密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td></td>
            <td align="right">
                <a href="register.jsp">注册</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" value="登录">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
