package day21.authorityManagement.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Day21LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");


        /*
        1:获取用户名
        2：判断用户名中是否包含niubi 如果包含，就是管理员，不包含就是普通会员
        3：把登录的用户名保存到session中
        4:转发到index.jsp
         */

        String username = req.getParameter("username");
        if(username.contains("niubi")){
            req.getSession().setAttribute("admin",username);
        }else {
            req.getSession().setAttribute("username",username);
        }
        req.getRequestDispatcher("/day21/day21index.jsp").forward(req,resp);

    }
}
