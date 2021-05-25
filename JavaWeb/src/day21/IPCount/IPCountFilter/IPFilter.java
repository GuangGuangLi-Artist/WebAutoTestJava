package day21.IPCount.IPCountFilter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Map;

/**
 * 从Application中获取Map
 * 从request中得到当前客户端的IP
 * 进行统计工作，结果保存到Map
 */

public class IPFilter  implements Filter {

    private FilterConfig config;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        //在服务器启动时就会执行本方法，而且本方法只执行一次！
        this.config = filterConfig;


    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        /*
         * 1. 得到application中的map
         * 2. 从request中获取当前客户端的ip地址
         * 3. 查看map中是否存在这个ip对应访问次数，如果存在，把次数+1再保存回去
         * 4. 如果不存在这个ip，那么说明是第一次访问本站，设置访问次数为1
         */
        //1. 得到appliction
        ServletContext app = config.getServletContext();
        Map<String,Integer> map = (Map<String, Integer>) app.getAttribute("map");
        //获取客户端ip地址
        String ip = servletRequest.getRemoteAddr();

        //进行判断
        if(map.containsKey(ip)){//这个ip在map中存在，说明不是第一次访问
            int count = map.get(ip);
            map.put(ip,count+1);

        }else {//这个ip在map中不存在，说明是第一次访问
            map.put(ip,1);
        }

        app.setAttribute("map",map);//把map放回到app中

        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}
