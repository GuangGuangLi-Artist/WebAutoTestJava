package day14.cn.itcast.user.web.servlet;

import day12.JavaBeanLearn.domain.CommonUtils;
import day14.cn.itcast.user.domain.User;
import day14.cn.itcast.user.service.UserException;
import day14.cn.itcast.user.service.UserService14;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet14 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        UserService14 userService = new UserService14();

        /**
         * 封装表单数据(封装到User中)
         * 调用UserService的regist()方法，传递form过去
         * 得到异常，获取异常信息，保存到request域，转发到register.jsp
         * 没有异常，输出注册成功
         *
         */

        User form = CommonUtils.toBean(req.getParameterMap(),User.class);
        try {
            userService.register(form);
            resp.getWriter().print("<h1>注册成功</h1><a href='" + req.getContextPath() +"/day14/user/login.jsp" + "'>点击这里去登录</a>");
        } catch (UserException e) {
            //获取异常，保存到request域
            req.setAttribute("msg",e.getMessage());
            //转发到register.jsp
            req.getRequestDispatcher("/day14/user/register.jsp").forward(req,resp);
        }
    }
}
