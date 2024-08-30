package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo02")
public class ServletDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("---ServletDemo02收到请求---");
        /**
         * 可以在浏览器 Network 的 Response Headers 中找到设置的响应头数据
         */
        // 设置响应头数据
        resp.setHeader("LOL","LeeSin");
        resp.setHeader("YaSuo","EEEEE");


        /**
         * 请求重定向：
         *   客户端访问服务器中的某个程序要获取资源，程序收到请求后，发现自己并没有此资源，
         *   然后程序告知客户端去哪里可以得到此资源，然后客户端再去这个地方请求获取资源。
         *
         *   做法是：使用 302 状态码，并设置响应头的 K 为 location 完成
         */
        // 302 : 告诉浏览器本次的请求需要继续访问其他的资源
        // 304 : 告诉浏览器本次的请求需要的资源与上次访问的资源相同，本次请使用缓存
        resp.setStatus(302);
      //  resp.setHeader("location","/Web02/demo02a");
        // 获取外部资源
        resp.setHeader("location","https://www.baidu.com");

        /**
         * 请求重定向的特点：
         *   请求重定向过程中浏览器地址栏会变为重定向后的URL。
         *   请求重定向不仅可以获取 web 内部资源，而且可以获取外部资源。
         */

        /**
         * 1、客户端会发出最少两次请求，第一次请求告诉客户端接着请求指定的其他资源
         * 2、重定向可以是本项目中的其他资源，也可以网络中任意的资源
         * 3、重定向是客户端行为，只是不需要用户手动操作而已，遇到302，就自动会找响应头中的location所指的资源路径
         * 4、重定向会导致浏览器的地址栏发生变化
         */
    }
}
