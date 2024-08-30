package com.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/cookie01")
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("请求已被 cookie01 接收到");
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("在浏览器控制台查看 cookie");
        /**
         * Cookie它是一种客户端技术，主要存在于浏览器端，在客户端（浏览器）访问服务器的时候，
         * 浏览器会处理Cookie相关的信息，进而在服务器内部的程序中，
         * 就可以获取关于当前某个客户端请求中携带的Cookie，分析客户端以前访问的一些数据情况。
         */
        // 设置 name 的属性值和编码格式
        String name = URLEncoder.encode("亚索", "utf-8");
        // 创建 cookie 对象
        Cookie cookie1 = new Cookie("name",name);
        Cookie cookie2 = new Cookie("address","aiouniya");
        Cookie cookie3 = new Cookie("price","6300");
        // 响应客户端的同时，添加 cookie 信息
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        resp.addCookie(cookie3);
    }
}
/**
 * 会话技术：从客户端开始访问服务器，最终到客户端关闭与服务器之间的数据交互，
 * 在这个过程中，可能存在若干个请求与响应。这些操作称为一次完整的客户端与服务器之间的一次会话。
 */
