package com.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  定义类，一般直接继承HttpServlet，而不要直接去实现Servlet接口（接口是不面向任何协议）
 *  HttpServlet它是针对http协议而实现Servlet，可以根据Http来处理请求和响应
 *  HttpServlet类中有个自定义的service方法，在其中获取来自客户端的请求方式getMethod()
 *  判断当前客户端使用具体是哪个请求方式，然后调用对应的doXxx方法
 *  因此我们在写Servlet程序的时候，只需要继承HttpServlet，复写doXxxx方法即可
 */
public class DemoServlet03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet.......");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost.......");
    }
}
