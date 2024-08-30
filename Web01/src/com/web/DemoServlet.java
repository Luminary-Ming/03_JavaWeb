package com.web;

import javax.servlet.*;
import javax.swing.*;
import java.io.IOException;

public class DemoServlet implements Servlet {
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
        System.out.println("接收到客户端的请求1");
        // servletResponse.setCharacterEncoding("utf-8");
        // servletResponse.setContentType("text/html")
        servletResponse.setContentType("text/html;charset=utf-8");
        servletResponse.getWriter().write("你好！我是太阳神！");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Servlet销毁");
    }
}
