package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo03a")
public class ServletDemo03a extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("---ServletDemo03a收到请求---");
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("已收到来自demo3的请求转发，并已处理");
    }
}
