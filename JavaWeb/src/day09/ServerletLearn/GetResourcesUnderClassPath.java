package day09.ServerletLearn;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class GetResourcesUnderClassPath extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 获取类路径下的资源
         * 得到ClassLoader
         *  >>>>先得到Class,再得到ClassLoader
         * 调用getRedourceAsStream(),得到一个InputStream
         */

        ClassLoader cl = this.getClass().getClassLoader();
        //相对/classes
        InputStream input = cl.getResourceAsStream("a.txt");

        String sresource = IOUtils.toString(input);//读取输入流内容，装换成字符串返回
        System.out.println(sresource);
        System.out.println("---------");



        Class c = this.getClass();
        //相对于.class文件所在的目录
        InputStream input1 = c.getResourceAsStream("b.txt");
        String sresourceclassfilePath = IOUtils.toString(input1);
        System.out.println(sresourceclassfilePath);
        System.out.println("---------");

        //相对于classes下

        InputStream input2 = c.getResourceAsStream("/c.txt");
        String sresourceuserclasses = IOUtils.toString(input2);
        System.out.println(sresourceuserclasses);







    }
}
