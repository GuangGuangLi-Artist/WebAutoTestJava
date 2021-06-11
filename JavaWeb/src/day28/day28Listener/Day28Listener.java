package day28.day28Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Day28Listener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("注解上的Listener出生了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("注解上的Listener要死了");

    }
}
