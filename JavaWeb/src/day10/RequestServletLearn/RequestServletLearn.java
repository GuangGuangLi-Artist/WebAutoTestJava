package day10.RequestServletLearn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestServletLearn extends HttpServlet {
    /**
     * 获取客户端的Ip,请求方式，获取User-Agent,得到客户端的信息（操作系统浏览器）
     *
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String IP = req.getRemoteAddr();
        System.out.println("IP:" + IP);

        System.out.println("请求方式:" + req.getMethod());

        String UserAgent = req.getHeader("User-Agent");
        System.out.println("User-Agent:" + UserAgent);

        //通过request获取url的相关方法
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print(req.getScheme() + "<br/>");//获取请求协议
        resp.getWriter().print(req.getServerName() + "<br/>");//获取服务器名称
        resp.getWriter().print(req.getServerPort() + "<br/>");//获取服务器端口号
        resp.getWriter().print(req.getContextPath() + "<br/>");//获取项目名称
        resp.getWriter().print(req.getServletPath() + "<br/>");//获取Servlet路径
        resp.getWriter().print(req.getQueryString() + "<br/>");//获取请求参数部分
        resp.getWriter().print(req.getRequestURI() + "<br/>");//获取请求URI
        resp.getWriter().print(req.getRequestURL() + "<br/>");//获取请求URL
    }
}
