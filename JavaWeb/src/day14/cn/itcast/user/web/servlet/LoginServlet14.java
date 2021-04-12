package day14.cn.itcast.user.web.servlet;

import day14.cn.itcast.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * UserServlet层
 */

public class LoginServlet14 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        req.setCharacterEncoding("utf-8");//请求编码
        resp.setContentType("text/html;charset=utf-8");//响应编码

        //依赖UserService
        UserService userService = new UserService();


    }
}
