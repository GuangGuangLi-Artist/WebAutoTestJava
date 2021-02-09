package day09.ServerletLearn;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class GenericServletLearn3 extends GenericServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("这是实现父类接口的自定义的init方法");
    }


    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("hello GenericServlet");
    }

    @Override
    public void destroy() {
        System.out.println("继承GenericServlet的方法");
    }
}
