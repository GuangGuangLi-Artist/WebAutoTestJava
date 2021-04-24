package day13.MVCLearn.servlet;

import day13.MVCLearn.domain.User;
import day13.MVCLearn.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 在servlet中依赖service，然后通过service完成功能，把结果保存到request中，转发到jsp页面
         */

        UserService userService = new UserService();
        User user = userService.find();

        req.setAttribute("usermng",user);

        req.getRequestDispatcher("/day13/MVCView/show.jsp").forward(req,resp);
    }
}
