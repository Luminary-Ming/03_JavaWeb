package com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class FilterDemo01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化...");
    }

    /**
     * 在过滤器拦截到请求之后，请求会自动的进入到过滤器的 doFilter() 方法中
     * 需要再 doFilter() 方法中书写业务逻辑，在符合某个条件的情况下，放行
     * doFilter() 方法的三个参数：
     *      servletRequest ：请求对象，可以通过这个对象获取请求中携带的所有数据
     *      servletResponse ：响应对象，可以通过这个对象给客户端响应数据
     *      filterChain ：过滤器链，完成放行操作
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器拦截到了请求");
        // 将 servletRequest 转成基于 HTTP 协议的 request 对象
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 获取请求访问的 servlet 路径
        String path = request.getServletPath();
        System.out.println(path);
        // 对访问 /img 下面的文件的请求，放行
        if(path.startsWith("/img")){
            // 放行
            filterChain.doFilter(request,servletResponse);
        }else{
            servletResponse.getWriter().write("您没有权限访问");
        }
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
