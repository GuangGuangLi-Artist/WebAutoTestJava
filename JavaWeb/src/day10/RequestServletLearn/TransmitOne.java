package day10.RequestServletLearn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TransmitOne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求转发的案例
        resp.setHeader("aaa","AAA");

        System.out.println("This is TransmitOne");

        //req.getRequestDispatcher("/TransmiTwo").forward(req,resp);//设置请求转发  常用 留头不留体

        resp.getWriter().print("aaa + ");
        req.getRequestDispatcher("/TransmiThree").include(req,resp);//留头又留体
    }
}
