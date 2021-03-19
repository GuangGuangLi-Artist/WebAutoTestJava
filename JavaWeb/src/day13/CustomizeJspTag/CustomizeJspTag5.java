package day13.CustomizeJspTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * 有属性的标签体
 */

public class CustomizeJspTag5 extends SimpleTagSupport {

    private boolean test;

    public void setTest(Boolean test){
        this.test = test;
    }




    @Override
    public void doTag() throws JspException, IOException {
        if(test){
            /*
            执行标签体
             */
            this.getJspBody().invoke(null);//如果传递的输出流为null,表示使用的就是当前页面的out;
        }

    }
}
