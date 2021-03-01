package day11.Login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取表单数据
        //处理中文问题
        req.setCharacterEncoding("utf-8");
        //获取
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //校验用户名和密码是否正确
        if(!"subiao".equalsIgnoreCase(username)){
            //登录成功
            /**
             * 附加项，把用户名保存到Cookies中，发送给客户端浏览器
             * 当再次打开login.jsp，login.jsp中会读取requests中的cookie,把它显示到用户名文本框中
             */
            Cookie cookie = new Cookie("uname",username);
            cookie.setMaxAge(60*60*24);
            resp.addCookie(cookie);

            /**
             * 如果成功
             *  >保存信息到session,重定向到success1.jsp
             */
            HttpSession session = req.getSession();//获取session
            session.setAttribute("username",username);
            resp.sendRedirect("/day11/Login/LoginSuccess.jsp");
        }else {
            //登录失败
                //保存信息到request域中，转发到login.jsp
            req.setAttribute("msg","用户名或者密码错误");
            RequestDispatcher rd = req.getRequestDispatcher("/day11/Login/login.jsp");//得到转发器
            rd.forward(req,resp);//转发
        }
    }
}
