package day22.upload;

import cn.itcast.utils.CommonUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
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

public class UploadLearn3 extends HttpServlet {

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
         *
         */
        //DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory(20*1024,new File("F://f/temp"));
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        //servletFileUpload.setFileSizeMax(1000*1024);
        //servletFileUpload.setSizeMax(1024*1024);

        try {
            List<FileItem> fileItemList = servletFileUpload.parseRequest(req);
            FileItem fileItem2 = fileItemList.get(1);

            //得到文件的保存路径
            String root = this.getServletContext().getRealPath("/WEB-INF/files/");
            /**
             * 生成二层目录
             * 得到文件名称
             * 得到hashcode
             * 转化成16进制
             * 获取前两个字符用来生成目录
             */
            String filename = fileItem2.getName();
            /*
            处理文件名的绝对路径问题
             */
            int index = filename.lastIndexOf("\\");
            if(index != -1){
                filename = filename.substring(index + 1);
            }
            //给文件名称添加uuid,处理文件同名问题
            String savename = CommonUtils.uuid() + "_" + filename;

            //得到hashcode
            int hCode = filename.hashCode();
            String hex = Integer.toHexString(hCode);

            File dirFile = new File(root,hex.charAt(0) + "/" + hex.charAt(1));

            //创建目录链
            dirFile.mkdirs();

            //创建目录文件
            File destFile = new File(dirFile,savename);


            //保存文件
            fileItem2.write(destFile);



        } catch (FileUploadException e) {
            if(e instanceof FileUploadBase.FileSizeLimitExceededException){
                req.setAttribute("msg","您上传的文件超出了1000kb");
                req.getRequestDispatcher("/day22/upload3.jsp").forward(req,resp);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
