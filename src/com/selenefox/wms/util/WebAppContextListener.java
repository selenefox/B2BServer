package com.selenefox.wms.util;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: selenefox
 * Date: 2011-4-2
 * Time: 17:40:03
 * WebApplactionContext获取模块
 */
public class WebAppContextListener implements ServletContextListener {
    private static WebApplicationContext springContext;
    private static Properties config;
    @Override
    public void contextInitialized(ServletContextEvent event) {
        springContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
        config = (Properties)springContext.getBean("configBean");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }

    public static ApplicationContext getApplicationContext() {
        return springContext;
    }
    public static Properties getConfig(){
        return config;
    }
}
