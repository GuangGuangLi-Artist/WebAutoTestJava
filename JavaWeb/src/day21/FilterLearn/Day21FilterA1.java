package day21.FilterLearn;

import javax.servlet.*;
import java.io.IOException;




//Filter是单例的

public class Day21FilterA1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        /*
        创建之后马上执行
         */
        System.out.println("过滤器要出生了");
    }

    @Override
    public void destroy() {
        /*
        销毁前执行
         */

        System.out.println("过滤器要死掉了");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /*
        每次过滤时都会执行
         */

        System.out.println("拦截你");
        filterChain.doFilter(servletRequest,servletResponse);//放行
        System.out.println("你回来了？");

    }
}
