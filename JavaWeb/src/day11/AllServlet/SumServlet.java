package day11.AllServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SumServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取jsp表单的数据
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");

        //转化为int类型
        int intnum1 = Integer.parseInt(num1);
        int intnum2 = Integer.parseInt(num2);

        //计算结果
        int res = intnum1 + intnum2;

        //将结果按照域属性传递
        req.setAttribute("res",res);

        //将结果转发到res.jsp
        req.getRequestDispatcher("/day11/sum/res.jsp").forward(req,resp);
    }
}
