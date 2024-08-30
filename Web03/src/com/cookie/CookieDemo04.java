package com.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookie04")
public class CookieDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        // 获取上次访问时间的 Cookie
        Cookie[] cookies = req.getCookies();
        Cookie cookie = getCookie(cookies, "lastTime");
        // 判断是否找到此 Cookie
        if (cookie == null) {
            // 没有找到对应的Cookie，给这个 Cookie 一个 lastTime 和 值
            resp.getWriter().write("你是第一次访问");
            // 第一次访问，创建一个 Cookie 添加最后一次访问时间，即 lastTime 和 值
            cookie = new Cookie("lastTime", new Date().getTime() + "");
        } else {
            // 获取这个 Cookie 的 value 值，也就是最后一次访问的时间（值是毫秒数）
            String value = cookie.getValue();
            // 将value中的毫秒数转换为日期
            Date date = new Date(Long.parseLong(value));
            // 转成对应的日期格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = sdf.format(date);
            // 访问时间打印在页面上
            resp.getWriter().write("你上次访问的时间是：" + format);
            // 然后重新设置访问时间
            cookie.setValue(String.valueOf(new Date().getTime()));
        }
        resp.addCookie(cookie);
    }

    /**
     * 从 Cookie[] 数组中，获取指定名称的 Cookie
     */
    private Cookie getCookie(Cookie[] cookies, String cookieName) {
        if (cookies != null) {
            // 遍历 Cookie[] 取出每个 cookie
            for (Cookie cookie : cookies) {
                // 判断取出 Cookie 的名称与指定的 Cookie 名称是否相同（判断是不是 lastTime）
                if (cookie.getName().equals(cookieName)) {
                    // 返回这个正确的 Cookie
                    return cookie;
                }
                // 本次请求中携带的 Cookie 没有 lastTime
                return null;
            }
        }
        // 本次请求中没有携带 Cookie
        return null;
    }
}