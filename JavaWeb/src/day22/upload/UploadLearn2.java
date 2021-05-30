package day22.upload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadLearn2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        /**
         * 上传三步
         * 1：得到工厂
         * 2：通过工厂创建解析器
         * 3：解析request,得到FileItem集合
         * 4：遍历FileItem集合，调用其API完成文件的保存
         */
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

        try {
            List<FileItem> fileItemList = servletFileUpload.parseRequest(req);
            FileItem fileItem1 = fileItemList.get(0);
            FileItem fileItem2 = fileItemList.get(1);

            System.out.println("普通表单项演示：" + fileItem1.getFieldName() + "=" + fileItem1.getString("UTF-8"));

            System.out.println("文件表单项演示：");
            System.out.println("Content-Type: " + fileItem2.getContentType());
            System.out.println("size: " + fileItem2.getSize());
            System.out.println("filename: " + fileItem2.getName());

            //保存文件
            File destFile = new File("E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day22\\savedFile\\ConfidentAndFearless.jpg");
            fileItem2.write(destFile);


        } catch (FileUploadException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            throw new RuntimeException(e);
        }


    }
}
