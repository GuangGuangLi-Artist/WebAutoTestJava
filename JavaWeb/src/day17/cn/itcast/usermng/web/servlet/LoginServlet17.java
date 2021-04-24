package day17.cn.itcast.usermng.web.servlet;

import day12.JavaBeanLearn.domain.CommonUtils;
import day17.cn.itcast.usermng.domain.User;
import day17.cn.itcast.usermng.service.UserException;
import day17.cn.itcast.usermng.service.UserService14;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * UserServlet层
 */

public class LoginServlet17 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        req.setCharacterEncoding("utf-8");//请求编码
        resp.setContentType("text/html;charset=utf-8");//响应编码

        //依赖UserService
        UserService14 userService = new UserService14() ;

        User form = CommonUtils.toBean(req.getParameterMap(), User.class);

        try {
            User user = userService.login(form);
            req.getSession().setAttribute("sessionUser",user);
            resp.sendRedirect(req.getContextPath() + "/day17/usermng/welcome.jsp");
        } catch (UserException e) {
            req.setAttribute("msg",e.getMessage());
            req.setAttribute("usermng",form);
            req.getRequestDispatcher("/day17/usermng/login.jsp").forward(req,resp);
        }


    }
}
