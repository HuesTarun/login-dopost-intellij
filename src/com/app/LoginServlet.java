package com.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        if ("admin".equals(user) && "admin123".equals(pass)) {
            response.sendRedirect("dashboard.html");
        } else {
            response.setContentType("text/html");
            response.getWriter().println("<script>");
            response.getWriter().println("alert('Wrong username or password!');");
            response.getWriter().println("window.location='index.html';");
            response.getWriter().println("</script>");
        }
    }
}
