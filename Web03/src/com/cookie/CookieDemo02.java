package com.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/cookie02")
public class CookieDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("请求已被 cookie02 接收到");
        // 获取请求中携带的 cookie
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie : cookies){
            // Key
            String name = cookie.getName();
            // Value
            String value = cookie.getValue();
            System.out.println(name+">>>>"+value);
            // name>>>>%E4%BA%9A%E7%B4%A2
            // address>>>>aiouniya
            // price>>>>6300
        }
    }
}
