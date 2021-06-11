package day28.Day28UploadServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(urlPatterns = "/Day28UploadServlet")
@MultipartConfig
public class Day28UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        //getParameter()方法可以使用了！！！
        String username = req.getParameter("username");

        //获取文件表单字段，对应的part对象
        Part part = req.getPart("resume");

        //从part中获取数据
        // 获取上传文件的MIME类型
        System.out.println(part.getContentType());
        // 获取上传文件的字节数
        System.out.println(part.getSize());

        // 获取文件字段名称
        System.out.println(part.getName());

        // 获取头，这个头中包含了上传文件的名称
        System.out.println(part.getHeader("Content-Disposition"));

        //保存上传文件
        part.write("F:\\音乐\\day28test.jpg   ");

        //获取上传文件名称
        String filename = part.getHeader("Content-Disposition");
        int start = filename.lastIndexOf("filename=\"") + 10;
        int end = filename.length() - 1;
        filename = filename.substring(start,end);
        System.out.println(filename);

    }
}
