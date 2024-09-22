package com.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextListenerDemo implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(" ServletContext 对象初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println(" ServletContext 对象销毁");
    }
}
