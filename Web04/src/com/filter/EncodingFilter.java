package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 拦截所有请求，处理编码问题
 */
@WebFilter(urlPatterns = "/*")
public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 设置全局的处理响应 text/html 文件的编码为 utf-8
        servletResponse.setContentType("text/html;charset=utf-8");
        // 放行
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
