package com.web;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet 的生命周期：从 Servlet 被创建到 Servlet 被销毁的过程
 * 一次创建，到处服务，一个 Servlet 只会有一个对象（单例），服务所有的请求
 *
 * 1. 实例化              使用构造方法创建对象
 * 2. 初始化              执行 init 方法
 * 3. 处理请求 （服务）    执行 service 方法
 * 4. 服务终止（销毁）     执行 destroy 方法
 *
 * 1. Servlet的创建时间：
 *      浏览器发出请求之后，首先会被 Tomcat 接收到，Tomcat 会扫描 web.xml配置文件或 @WebServlet注解，
 *      从而找到对应的 Servlet类，这时 Tomcat会判断当前访问的 Servlet类是否有创建对象，如果是外界第一次访问该 Servlet类，
 *      那么 Tomcat会立刻创建这个 Servlet类的对象，然后去调用 Servlet类中的 service方法，最终调用 doXxx方法来处理请求。
 * 2. Servlet的销毁时间：
 *        1. 关闭服务器时；
 *        2. 将 Servlet所在的项目从服务器中移除时；
 *
 *  Servlet的对象创建完成后会一直存在，后续的只要是请求这个 Servlet类，就会一直对外提供处理请求和响应服务。
 *
 *  在配置 Servlet时，可以修改 Servlet对象的创建时间：（ loadOnStartup 默认值是 -1 ）
 *       在 web.xml中配置：<load-on-startup>1</load-on-startup>
 *       在 @WebServlet注解中配置：@WebServlet(loadOnStartup = 1)
 *  loadOnStartup 的值是一个整数，表示在 Servlet容器（如Tomcat）中 Servlet的加载顺序。值越小，Servlet的加载优先级就越高，即越早被加载和初始化。
 *
 *  当你需要在Servlet容器启动时立即执行一些初始化操作（比如加载配置文件、初始化数据库连接池等）时。
 *  通过将这些操作放在Servlet的init()方法中，并设置合适的loadOnStartup值，可以确保这些操作在Servlet容器启动时就完成，
 *  从而避免了在第一次请求到达时才进行初始化可能导致的延迟。
 *  如果Servlet没有设置loadOnStartup参数，或者其值被设置为负数，那么Servlet将不会在Servlet容器启动时自动加载和初始化，
 *  而是会在接收到第一个请求时才进行加载和初始化。
 */
@WebServlet(urlPatterns = "/demo4", loadOnStartup = 9)
public class DemoServlet04 extends HttpServlet {
    public DemoServlet04(){
        System.out.println("Servlet4被创建");
    }

    /** 当 Servlet第一次被创建对象时执行该方法，在整个生命周期中只执行一次 */
    @Override
    public void init() throws ServletException {
        System.out.println("Servlet4初始化");
    }

    /** 对客户端相应的方法，该方法会被执行多次，每次请求都会调用 service 方法 */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("收到客户端请求！4");
    }

    /** doGet方法是 service方法中调用的方法*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到 get请求！4");
    }

    /** 当 Servlet销毁时执行该方法 */
    @Override
    public void destroy() {
        System.out.println("Servlet4销毁了");
    }

}
