package day09.ServerletLearn;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class getContextParam extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 获取全局的初始化参数
         * 1：获取到GetServletContext
         * 2：获取到全局的初始化参数的值
         */
        ServletContext application = this.getServletContext();
        String ContextValue = application.getInitParameter("context_param");
        System.out.println(ContextValue);
    }
}
