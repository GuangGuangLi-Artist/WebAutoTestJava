package day09.ServerletLearn;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CountVisit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 统计访问量
         *
         * 获取ServletContext对象
         * 从ServletContext对象中获取名为count的属性
         * 如果存在，给访问量加1，然后保存回去
         * 如果不存在，说明是第一次访问，向ServletContext中保存名为count的属性，值为1
         */

        ServletContext app = this.getServletContext();
        Integer count = (Integer)app.getAttribute("count");
        if(count == null){
            app.setAttribute("count",1);
        }else {
            app.setAttribute("count",count+1);
        }

        //向浏览器输出
        PrintWriter pw = resp.getWriter();
        pw.print("<h1>" + count + "</h1>");
    }
}
