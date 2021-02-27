package day10.RequestServletLearn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseEncoding  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");//最常用的方式
        resp.setHeader("Content-Type","text/html;charset=utf-8");
        resp.getWriter().print("这是中文的响应");
        /**
         * 1:先获取来使用ISO的错误字符串
         * 2：回退，使用utf-8重编
         */
        String name1 = req.getParameter("username");
        byte[] bys = name1.getBytes("ISO-8859-1");
        name1 =  new String(bys,"UTF-8");
        System.out.println(name1);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 1：在获取参数之前，需要先调用request,setCharacterEncoding("utf-8");
         * 2:使用getParameter()来获取参数
         */

        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        System.out.println(username);
    }
}
