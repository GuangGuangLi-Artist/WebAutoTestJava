package day21.IPCount.IPCountListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.LinkedHashMap;
import java.util.Map;

public class IPCountListener implements ServletContextListener {

    /**
     * 在服务器启动时创建Map,保存到ServletContext
     * @param sce
     */

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Map<String,Integer> map = new LinkedHashMap<String, Integer>();

        ServletContext application = sce.getServletContext();

        application.setAttribute("map",map);



    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
