package day28.asyncContextLearn;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/AsyncContextLearn",asyncSupported = true)
public class AsyncContextLearn  extends HttpServlet {


    @Override
    protected void doGet( final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        //支持IE,如果输出不足512b,没有异步效果
        for (int i = 0; i <= 512 ; i++) {
            resp.getWriter().print('a');

        }
        resp.getWriter().flush();


        //得到异步上下文对象
        final AsyncContext asyncContext = req.startAsync(req,resp);

        //给上下文对象一个Runable对象，让他执行这个任务
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                myPrintln("现在马上开始<br/>", resp);
                mySleep(2000);
                for (char c = 'A'; c < 'z'; c++) {
                    myPrintln(c + "",resp);
                    mySleep(250);

                }

                //通知tomcat,我们已经执行结束
            }
        });
    }


    public void myPrintln(String text,HttpServletResponse response){
        try {
            response.getWriter().print(text);
            response.getWriter().flush();
        } catch (IOException e) {

        }
    }

    public void mySleep(long ms){

        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {

        }
    }
}
