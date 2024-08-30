package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo01")
public class ServletDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 测试后端是否收到客户端的请求
        System.out.println("---ServletDemo01收到请求---");

        /**
         * 常见的 HTTP 状态码：
         *   1xx ：信息响应，服务器收到请求，需要请求者继续执行操作
         *   2xx ：成功响应，请求已被接收，并且已完成处理
         *   3xx ：重定向，需要进一步操作才能完成这一请求
         *   4xx ：客户端错误，请求包含语法错误或找不到此资源。
         *   5xx ：服务器错误，服务器在处理请求的过程中发生了错误。
         */
        // 设置响应状态码
        resp.setStatus(500);


    }
}
