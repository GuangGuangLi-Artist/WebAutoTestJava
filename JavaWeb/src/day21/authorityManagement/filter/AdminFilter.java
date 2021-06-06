package day21.authorityManagement.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        /*
        1：得到session,
        2:判断session域中是否有admin,如果存在，放行
        3;判断session狱中是否存在username，有就放行，否则打回到login.jsp,并给出提示
         */
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String name = (String) request.getSession().getAttribute("admin");
        if(name != null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            request.setAttribute("msg","您可能是个啥，但肯定不是管理员！");
            request.getRequestDispatcher("/day21/day21Login.jsp").forward(servletRequest,servletResponse);
        }

    }
}
