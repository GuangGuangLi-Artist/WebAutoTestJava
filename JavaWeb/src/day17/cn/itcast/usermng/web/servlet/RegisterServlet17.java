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
import java.util.HashMap;
import java.util.Map;

public class RegisterServlet17 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //resp.getWriter().print("注册来了");

        UserService14 userService = new UserService14();





        /**
         * 封装表单数据(封装到User中)
         * 调用UserService的regist()方法，传递form过去
         * 得到异常，获取异常信息，保存到request域，转发到register.jsp
         * 没有异常，输出注册成功
         *
         */

        User form = CommonUtils.toBean(req.getParameterMap(), User.class);

        /**
         * 添加新任务（表单校验）
         */
        Map<String,String> errors = new HashMap<String,String>();

        String username = form.getUsername();
        if(username == null || username.trim().isEmpty()){
            errors.put("username","用户名不能为空！");
        }else if(username.length() < 3 || username.length() > 15){
            errors.put("username","用户名长度必须在3-15之间！");
        }

        String password = form.getPassword();
        if(password == null || password.trim().isEmpty()){
            errors.put("password","密码不能为空！");
        }else if(password.length() < 3 || password.length() > 15){
            errors.put("password","密码长度必须在3-15之间");
        }

        String  sessionVerifyCode = (String) req.getSession().getAttribute("session_vcode");
        String verifyCode = form.getVerifyCode();
        if(verifyCode == null || verifyCode.trim().isEmpty()){
            errors.put("verifyCode","验证码不能为空");
        }else if(verifyCode.length() !=4){
            errors.put("verifyCode","验证码长度必须为4");
        }else if(!verifyCode.equalsIgnoreCase(sessionVerifyCode)){
            errors.put("verifyCode","验证码错误");
        }

        if(errors != null && errors.size() > 0){
            req.setAttribute("errors",errors);
            req.setAttribute("usermng",form);
            req.getRequestDispatcher("/day17/usermng/register.jsp").forward(req,resp);
            return;
        }

        try {
            userService.register(form);
            resp.getWriter().print("<h1>注册成功</h1><a href='" + req.getContextPath() +"/day17/usermng/login.jsp" + "'>点击这里去登录</a>");
        } catch (UserException e) {
            //获取异常，保存到request域
            req.setAttribute("msg",e.getMessage());
            req.setAttribute("usermng",form);//用来在表单中回显
            //转发到register.jsp
            req.getRequestDispatcher("/day17/usermng/register.jsp").forward(req,resp);
        }
    }
}
