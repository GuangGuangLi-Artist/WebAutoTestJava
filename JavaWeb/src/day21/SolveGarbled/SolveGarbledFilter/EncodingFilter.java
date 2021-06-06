package day21.SolveGarbled.SolveGarbledFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            //处理post请求的编码问题
        servletRequest.setCharacterEncoding("UTF-8");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //处理GET请求的编码问题
//        String username = request.getParameter("username");
//        username = new String(username.getBytes("ISO-8859-1"),"UTF-8");

        /*
        调包request
        1:写一个request的装饰类
        2:在放行时，使用我们自己的request
         */
        if(request.getMethod().equals("GET")){
            EncodingRequest er = new EncodingRequest(request);
            filterChain.doFilter(er,servletResponse);
        }else if(request.getMethod().equals("POST")){
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
