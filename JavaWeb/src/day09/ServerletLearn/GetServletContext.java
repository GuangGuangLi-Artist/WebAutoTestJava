package day09.ServerletLearn;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetServletContext extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletContext数据的值
        /**
         * 1:获取ServletContext对象
         * 2：获取获取ServletContext对象的值
         */
        ServletContext application = this.getServletContext();
        String name = (String) application.getAttribute("name");
        System.out.println(name);
    }
}
