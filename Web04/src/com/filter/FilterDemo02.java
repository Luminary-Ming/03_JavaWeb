package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 过滤器的生命周期：
 *      创建：在 Tomcat 启动的过程中，会加载已经部署在 Tomcat 中的项目，加载项目的时候会读取 web.xml 配置文件或 @WebFilter 注解信息，
 *          读取到对应的 Filter 相关配置后，就开始创建 Filter 的对象，并且初始化对象。
 *      销毁：
 *          1. 关闭服务器
 *          2. 项目从 Tomcat 中移除
 */
@WebFilter(
        urlPatterns = "/Web04",
        filterName="FilterDemo02",
        initParams = {
                @WebInitParam(name="username",value="yasuo"),
                @WebInitParam(name="age",value="20")
        }
)
public class FilterDemo02 implements Filter {
    public FilterDemo02(){
        System.out.println("过滤器创建");
    }

    /**
     *  FilterConfig ：表示过滤器在初始化时，可以去读取配置文件或者注解中配置的一些初始化相关的参数
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
        // 获取过滤器注解中的初始化参数
        String username = filterConfig.getInitParameter("username");
        String age = filterConfig.getInitParameter("age");
        System.out.println(username);
        System.out.println(age);
        // 获取过滤器注解中的初始化参数
        Enumeration<String> en = filterConfig.getInitParameterNames();
        while(en.hasMoreElements()){
            System.out.println(en.nextElement());
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器拦截到请求");
        // 放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
