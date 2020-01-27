package com.company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletAjax", urlPatterns = {"/ServletAjax"})
public class ServletAjax extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        switch (request.getParameter("type")) {
            case "register": {
                if (SqlLiteHelper.select(request.getParameter("name"))) {
                    out.print("true");
                } else {
                    out.print("false");
                }
            }
            break;

            case "session": {
                //处理session
                UserObject userObject = (UserObject) request.getSession().getAttribute("user");
                if (userObject == null) {
                    out.print("null");
                } else {
                    out.print(userObject.getUser());
                }
            }
            break;

            case "login": {
                String user = request.getParameter("user");
                String password = request.getParameter("password");
                UserObject userObject = new UserObject(user, password);
                if (SqlLiteHelper.select(userObject)) {
                    out.print("true");
                } else {
                    out.print("false");
                }
            }
            break;

            default:
                break;
        }
    }

}
