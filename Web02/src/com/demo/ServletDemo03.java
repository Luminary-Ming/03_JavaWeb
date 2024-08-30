package com.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo03")
public class ServletDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("---ServletDemo03收到请求---");

        // 获取一个请求转发的转发器对象    参数是 Servlet 的路径
        RequestDispatcher dispatcher = req.getRequestDispatcher("/demo03a");
        // 进行请求转发操作
        dispatcher.forward(req,resp);
        /**
         * 请求转发：
         *   客户端向服务器某个程序获取资源，但是这个程序没有此资源，然后在服务器内部程序会把这个请求转发给另一个程序，
         *   直到在一个程序中找到了此资源，然后回应给客户端，客户端得到此资源。
         *
         * 请求转发的特点：
         *   请求转发过程中，浏览器地址栏不会发生变化，仍然是最初请求的URL。
         *   请求转发只能获取 web 内部有的资源，不能获取外部资源。
         */
        /**
         * 客户端发出一次请求，然后在服务器内部的程序中，进行本次请求的跳转。
         * 请求AServlet，在AServlet中，使用request对象，获取到转发器，转到BServlet（jsp）等当前项目的其他资源。
         *
         * 1. 转发的客户端只发出一次请求，客户端并不知道数据来自于其他的项目内部程序
         * 2. 多次转发，他们共享同一个request和response
         * 3. 转发的时候，不能形成嵌套调用。
         */
    }
}
