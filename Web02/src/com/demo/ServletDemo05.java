package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo05")
public class ServletDemo05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取客户端的请求方式
        String method = req.getMethod();
        System.out.println(method);  // GET

        // 获取客户端的IP地址
        String ip = req.getRemoteHost();
        System.out.println(ip);  // ::1

        // 获取请求头信息
        String acceptEncoding = req.getHeader("accept-encoding");
        System.out.println(acceptEncoding);  // gzip, deflate, br, zstd
        String userAgent = req.getHeader("user-agent");
        System.out.println(userAgent);  // Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36

        // 获取请求当前Servlet的请求路径
        String servletPath = req.getServletPath();
        System.out.println(servletPath);  // /demo05

        // 获取请求当前项目的根路径
        String contextPath = req.getContextPath();
        System.out.println(contextPath);  // /Web02

        // 获取请求地址，不包含携带的参数
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);  // /Web02/demo05

        // 获取请求地址携带的参数
        String queryString = req.getQueryString();
        System.out.println(queryString);  // K=V
    }
}
