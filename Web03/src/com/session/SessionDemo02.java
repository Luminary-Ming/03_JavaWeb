package com.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session02")
public class SessionDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获得这个客户端的 Session对象
        HttpSession session = req.getSession();
        // 获得 Session对象中存储的数据
        Object name = session.getAttribute("name");
        System.out.println("name = " + name);
    }
}
/**
 * 服务器识别客户端的session对象依赖的是：服务器在创建Session对象的时候，
 * 给每个Session绑定了一个唯一的 JSESSIONID 的字符串数据。
 *
 * 在客户端访问到服务器之后，服务器内部创建出session，而且在服务器内部给客户端响应数据的时候，
 * 将 JSESSIONID 作为 cookie 的数据一起发送给客户端。
 *
 * 后续客户端访问的时候，会携带 JSESSIONID，服务器通过jsessionid就可以找到当前这个客户端的session对象
 *
 * 如果浏览器将cookie禁用了，导致每次访问服务器，即使session存在，服务器也无法找到对应的session对象。
 * 因为客户端请求的时候不会携带 JSESSIONID 。
 */