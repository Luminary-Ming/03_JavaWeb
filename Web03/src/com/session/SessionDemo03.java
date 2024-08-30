package com.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session03")
public class SessionDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * HttpSession 的生命周期：
         *   创建：
         *     在 Servlet 中，第一次调用 getSession() 方法的时候，服务器中没有对应这个客户端的 Session对象，
         *     服务器就会针对这个客户端创建一个 Session对象，同时生成 JSESSIONID 的cookie信息。
         *     后续调用 getSession() , 直接返回 session 对象。
         *
         *     如果调用的 getSession( boolean b ) 有传入一个布尔值：
         *       传递的参数为 true 时，效果和 getSession() 相同。
         *       传递的参数为 false 时，只会获取 session对象，不会创建 session 对象。
         *
         *   销毁：
         *     1. session 的默认存活时间是 30 分钟，在此期间客户端再也没有向服务器发送请求时，session 就会销毁。
         *       session 可以修改存活时间：
         *         在 tomcat 的项目管理页面中针对每个项目都可以单独设置 session 的过期时间。
         *         也可以在当前项目的web.xml文件中设置：
         *                       <session-config>
         *                            <session-timeout>1</session-timeout>
         *                       </session-config>
         *     2. 不正常关闭服务器（如突然断电、系统崩溃等），session 随着 tomcat服务器的不正常关闭而销毁。
         *         正常关闭服务器，tomcat 会将当前内存中的所有 session 通过 io对象（对象序列化技术）存储在 tomcat 的 work 目录下。
         *         下次启动 tomcat 的时候，会进行反序列化，然后将其加载回来。（session的钝化和活化）。
         *     3. 直接调用session的销毁方法： session.invalidate();
         */
        HttpSession session = req.getSession(false);
        System.out.println(session);
    }
}
