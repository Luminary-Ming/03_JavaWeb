package com.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * JavaWeb 中的监听器有 8 个，分为三组：
 *      第一组：用于监听 Request、Session、ServletContext 对象的创建和销毁。
 *      第二组：用于监听 Request、Session、ServletContext 对象中数据的添加、修改、删除。
 *      第三组：用于专门监听 Session
 *          1. 监听 Session 钝化（Session 对象通过 IO 流写到 Tomcat 的 work 目录中）和活化（Tomcat 在启动的时候，从 work 目录中使用 IO 流读取存储的 Session 对象）。
 *          2. 监听 Session 中的对象（bean）的添加和移除操作。
 */
@WebListener
public class RequestListenerDemo implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request 对象被销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("request 对象创建后在初始化");
    }
}
