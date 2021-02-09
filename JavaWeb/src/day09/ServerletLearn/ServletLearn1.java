package day09.ServerletLearn;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class ServletLearn1 implements Servlet {

    /*
        他是生命周期方法
        在servlet对象创建之后马上执行，并只执行一次
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
        //获取初始化参数
        System.out.println(servletConfig.getInitParameter("p1"));
        System.out.println(servletConfig.getInitParameter("p1"));

        //获取所有初始化参数的名称
        Enumeration e = servletConfig.getInitParameterNames();
        while (e.hasMoreElements()){
            System.out.println(e.nextElement());
        }

    }


    //获取servlet的配置信息
    @Override
    public ServletConfig getServletConfig() {
        //System.out.println("getServletConfig");
        return null;
    }

    /*
        他是生命周期方法
        会被调用多次，每次处理请求都是调用这个方法
     */

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service");
    }




    //获取servlet的信息
    @Override
    public String getServletInfo() {

        System.out.println("getServletInfo");
        return "我是一个快乐的servlet";
    }


    /*
        他是生命周期方法
        在servlet被销毁之前调用，并且只会被调用一次
     */
    @Override
    public void destroy() {
        System.out.println("destroy");

    }
}
