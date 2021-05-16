package day19.BaseServletLearn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Day19BServlet extends Day19BaseServlet {

    public String fun1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("fun1()...");
        return "/index.jsp";
    }


    public String fun2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("fun2()...");
        return "r:/index.jsp";
    }

    public String fun3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("fun3()...");
        return "d:/WEB-INF/files/a.rmvb";
    }
}
