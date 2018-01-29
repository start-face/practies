package com.tuhao.base;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class Demo1 extends HttpServlet{

    @Override
    public void init(){
        System.err.println("初始化完成！");
    }

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

        System.err.println("进入doGet方法了！");
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        String requestURI = request.getRequestURI();
        String s = request.getRequestURL().toString();
        String protocol = request.getProtocol();
        String method = request.getMethod();

        List<Object> list = new LinkedList<>();

        for (Cookie cookie:cookies){
            list.add(cookie.getName());
            list.add(cookie.getValue());
        }

        list.add(requestURI);
        list.add(s);
        list.add(protocol);
        list.add(method);
        response.getWriter().write("进入doGet方法了！");
        PrintWriter out = response.getWriter();
        out.println(list);
//        request.getRequestDispatcher("success.jsp").forward(request,response);
    }

    @Override
    public void destroy(){
        System.out.println("==============================销毁系统了！==============================");
    }
}
