<%@ page import="static com.company.UserUtils.ValidChars" %>
<%@ page import="com.company.SqlLiteHelper" %>
<%@ page import="com.company.UserObject" %><%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册账户</title>
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
        if (SqlLiteHelper.insert(userObject)) {
%>
注册成功，<a href="login.jsp">前往登录</a>
<%
} else {
%>
注册失败，请检查！
<%
        }
    }
%>
<form action="register.jsp" method="post">
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
                <input type="submit" value="注册">
            </td>
        </tr>
    </table>
</form>
<h4 style="color: red">
    用户名、密码 必须为 数字、大小写字母！
</h4>
</body>
</html>