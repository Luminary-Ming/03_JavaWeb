package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo06")
public class ServletDemo06 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("---ServletDemo06收到请求---");
        /**
         * 盗链：在自己网页上盗链别人网站的资源。
         * 防盗链：防止别的网站盗链自己的网站的资源。
         *
         * 如果访问当前的这个Servlet程序，必须要通过指定的网页来访问，而不许直接访问，
         * 这时通过指定页面访问的时候，请求头中一定会携带 referer 头信息。
         * 而且值为当前页面的地址栏中的地址信息。
         *
         * 当链接过来的时候，referer的值是链接过来的页面的URL
         * 刷新的时候referer的值为 null
         */
        // 得到通过链接过来的那个页面的 URL
        String referer = req.getHeader("referer");
        // 判断是否携带指定头信息的内容
        if(referer == null || !"http://localhost/Web02/01.html".equalsIgnoreCase(referer)){
            resp.getWriter().write("你盗链老子资源，不想活了！？");
        }else{
            resp.getWriter().write("欢迎光临，你可以继续访问保密数据");
        }
    }
}
