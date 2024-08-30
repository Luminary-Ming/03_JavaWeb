package com.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/abc2")
public class DemoServlet02 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Servlet初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("接收到客户端的请求2");
        // 告诉客户端数据采用的编码
        servletResponse.setContentType("text/html;charset=utf-8");
        // 给客户端
        PrintWriter writer = servletResponse.getWriter();
        writer.write("<h1>弗雷尔卓德之心 布隆</h1>");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
