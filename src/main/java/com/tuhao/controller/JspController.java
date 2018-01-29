package com.tuhao.controller;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @autor FaceFeel
 * @create 2017-09-17 20:02
 */

@WebServlet("/jsp")
public class JspController extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.err.println("has join in the service method!");
        request.getRequestDispatcher("jspTag.jsp").forward(request,response);
    }
}
