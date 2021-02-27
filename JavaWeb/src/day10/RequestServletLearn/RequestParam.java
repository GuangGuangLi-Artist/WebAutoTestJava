package day10.RequestServletLearn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

public class RequestParam extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get:" + req.getParameter("xxx"));
        System.out.println("get:" + req.getParameter("yyy"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobby = req.getParameterValues("hobby");

        System.out.println("username:" + userName + " password:" + password + " hobby:" + Arrays.toString(hobby));
        System.out.println("=============");

        //测试获取所有请求参数名称
        Enumeration names = req.getParameterNames();
        while (names.hasMoreElements()){
            System.out.println(names.nextElement());
        }

        System.out.println("=============");

        //获取所有的请求参数 分装到Map
        Map<String,String[]> map = req.getParameterMap();
        System.out.println(map);
        for (String name:map.keySet()){
            String[] values = map.get(name);
            System.out.println(name + "=" + Arrays.toString(values));
        }

    }
}
