package day09.ServerletLearn;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自己实现一个GenericServlet
 */

public class GenericServletLearn1 implements Servlet {
    private ServletConfig config;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //把tomcat传递的servletConfig赋值给本类的一个成员，其实就是把它保存起来，方便在方法中使用
        this.config = servletConfig;
        init();

    }

    //这个方法是自己定义的，不是Servlet接口中的方法
    public void init(){

    }

    //这个方法会在init()方法后被调用，init被调用后，本类的this.config已经有值了
    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("每次处理请求会被调用");

    }

    /*
        爱实现不实现
     */
    @Override
    public String getServletInfo() {
        return "我是一个快乐的servlet";
    }

    @Override
    public void destroy() {
        System.out.println("啊 我要死了");

    }

    public ServletContext getServlerContext(){
        return config.getServletContext();
    }
    public String getServletName(){
        return config.getServletName();
    }

    public String getInitParameter(String name){
        return config.getInitParameter(name);
    }
}
