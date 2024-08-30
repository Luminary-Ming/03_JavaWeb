package com.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie03")
public class CookieDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("请求已被 cookie03 接收到");

        // 在 cookie 中重新给 name 赋值（原值为：亚索）
        Cookie cookie = new Cookie("name", "HHHHHa");

        /**
         * Cookie 的分类：
         * 临时 Cookie ：它仅存在于浏览器会话期间，浏览器关闭后，Cookie 消失。
         * 持久 Cookie ：可以给 Cookie 设置过期时间，只要客户端在一段时间内没有再访问过，Cookie 就会过期消失。
         */
        // 给 cookie 设置过期时间 7天后过期
        // 时间单位是秒
        cookie.setMaxAge(60*60*24*7);

        // 设置cookie对应的域名
        // 一般不设置，默认为当前对应的服务器的域名
        // 如果设置的域名和服务器的域名不一致，当前的cookie称为第三方cookie，浏览器默认不接受
//      cookie.setDomain("www.baidu.com");  // 可以在浏览器控制台 Network 中的 Response Headers 中的 set-cookie 中找到

        // cookie的有效路径，访问指定路径的时候才会携带对应的cookie，默认值是当前项目的路径
        // 我们一般设置为 setPath("/") 这样所有项目都共享此 Cookie
        // setPath("/Web02") 这样设置指当前 Cookie 只在项目 Web02 中存在，而 Web03 中此 Cookie 消失
        cookie.setPath("/Web02");

        resp.addCookie(cookie);
    }
}
