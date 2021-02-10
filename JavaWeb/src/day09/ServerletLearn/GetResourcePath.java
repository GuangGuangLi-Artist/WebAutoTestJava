package day09.ServerletLearn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class GetResourcePath extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 使用ServletContext获取资源路径
         *
         */

        String path = this.getServletContext().getRealPath("/index.jsp");
        System.out.println("盘符路径:" + path);//E:\ideaworkspace\WebAutoTestJava\JavaWeb\out\artifacts\web_war_exploded\index.jsp

        /**
         * 获取资源路径后，再创建输入流对象
         */
        InputStream input = this.getServletContext().getResourceAsStream("/index.jsp");


        /**
         * 获取当前路径下的所有资源的路径
         */
        Set<String> paths = this.getServletContext().getResourcePaths("/WEB-INF");
        System.out.println(paths);//[/WEB-INF/classes/, /WEB-INF/web.xml]

    }
}
