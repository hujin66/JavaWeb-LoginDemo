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
        String user = request.getParameter("name");
        if (SqlLiteHelper.select(user)) {
            out.print("true");
        } else {
            out.print("false");
        }
    }

}
