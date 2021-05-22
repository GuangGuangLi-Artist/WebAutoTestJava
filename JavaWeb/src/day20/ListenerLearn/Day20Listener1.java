package day20.ListenerLearn;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Day20Listener1 implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("哇，我来也");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("哇，我要去也！");

    }
}
