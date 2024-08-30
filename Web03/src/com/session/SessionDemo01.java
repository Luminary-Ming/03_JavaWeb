package com.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session01")
public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 在 Servlet 中，不能直接去 new Session() 来创建 Session对象，
         * 而是需要用 req.getSession() 来得到 Session对象，
         * 因为 Session对象是 Tomcat 创建的。
         * 在第一次调用 getSession() 方法时，服务器中没有对应这个客户端的 Session对象，
         * 服务器就会针对这个客户端创建一个 Session对象。
         */
        // 获得这个客户端的 Session对象
        HttpSession session = req.getSession();
        System.out.println(session);
        // 给这个 session 存储数据
        session.setAttribute("name","亚索");
    }
}
/**
 * web服务器：可以对外提供服务，无法去运行对应的应用程序（Java、PHP等），
 *           可以提供一些静态资源(HTML、CSS、JS等)的访问，例如：Nginx、IIS、Apache Server.
 *
 * web应用服务器：可以对外提供服务，可以运行对应的语言编写的程序（Tomcat，运行Servlet、JSP等程序）
 *
 * JavaEE相关的web应用服务器：Tomcat、weblogic、jboss，它们也可以称为web容器（Servlet容器）。
 */