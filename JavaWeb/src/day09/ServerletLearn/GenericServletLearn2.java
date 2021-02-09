package day09.ServerletLearn;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class GenericServletLearn2 extends GenericServletLearn1 {

    @Override
    public void init() {
        //把tomcat传递的servletConfig赋值给本类的一个成员，其实就是把它保存起来，方便在方法中使用
        System.out.println("哈哈哈");

    }

    String value = getInitParameter("p1");//等价于super.getInitParameter("p1");

}
