package day22.download;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class DownloadLearn1  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 两个头一个流
         * 1.Content-Type
         * 2.Content-Disposition
         * 3.流：下载文件的数据
         */
        String filename = "F:\\音乐\\周杰伦无损\\十二新作\\周杰伦 - 红尘客栈.flac";
        //为了使下载框显示的中文文件名称不出乱码
        String framename = filenameEncoding("周杰伦 - 红尘客栈.flac",req);

        String contentType = this.getServletContext().getMimeType(filename);//通过文件名获取MIME类型
        String contentDisposition = "attachment;filename=" + framename;
        //一个流
        FileInputStream fileInputStream = new FileInputStream(filename);
        //设置头
        resp.setHeader("Content-Type",contentType);
        resp.setHeader("Content-Disposition",contentDisposition);

        //获取绑定了响应端的流
        ServletOutputStream outputStream = resp.getOutputStream();

        IOUtils.copy(fileInputStream,outputStream);//把输入流的数据写入到输出流中
        fileInputStream.close();

    }

    //用来对下载的文件名称进行编码的！
    public static  String filenameEncoding(String filename,HttpServletRequest request) throws UnsupportedEncodingException {
        String agent = request.getHeader("User-Agent");
        if(agent.contains("Firefox")){
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filename = "?UTF-8?B?" + base64Encoder.encode(filename.getBytes("UTF-8")) + "?=";
        }else if(agent.contains("MSIE")){
            filename = URLEncoder.encode(filename,"UTF-8");
        }else {
            filename = URLEncoder.encode(filename,"UTF-8");
        }
        return filename;
    }
}
