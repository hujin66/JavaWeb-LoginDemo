package com.company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletLogin",urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        UserObject userObject = new UserObject(user, password);
        String result;
        if(SqlLiteHelper.select(userObject)){
            result="<h3>欢迎," +
                    user +
                    "</h3><a href='logout.html'></a>";
        }
    }

}
