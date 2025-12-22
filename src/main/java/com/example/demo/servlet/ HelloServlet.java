package com.example.demo.servlet;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    @Override
    public void init() {
        getServletContext().setAttribute("message", "Hello Tomcat");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.getWriter().write("Hello from servlet");
    }
}
