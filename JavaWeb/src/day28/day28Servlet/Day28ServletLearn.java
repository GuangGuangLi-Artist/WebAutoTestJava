package day28.day28Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 *
 * <servlet>
 *   <servlet-name>AServlet</servlet-name>
 *   <servlet-class>cn.itcast.web.servlet.AServlet</servlet-class>
 *   <init-param>
 *     <param-name>p1</param-name>
 *     <param-value>v1</param-value>
 *   </init-param>
 *   <init-param>
 *     <param-name>p2</param-name>
 *     <param-value>v2</param-value>
 *   </init-param>
 *   <load-on-startup>1<load-on-startup>
 * </servlet>
 * <servlet-mapping>
 *   <servlet-name>AServlet</servlet-name>
 *   <url-pattern>/AServlet</url-pattern>
 *   <url-pattern>/AAServlet</url-pattern>
 * </servlet-mapping>
 *
 *
 */
@WebServlet(urlPatterns = "/Day28ServletLearn",initParams = {
        @WebInitParam(name = "p1",value = "v1"),
        @WebInitParam(name = "p2",value = "v2"),
})
public class Day28ServletLearn extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello servlet3.0+ !!!");
        resp.getWriter().print("hello servlet3.0+ !!!");

    }
}
