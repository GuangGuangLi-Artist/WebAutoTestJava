package day13.CustomizeJspTag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import java.io.IOException;

/**
 * 自定义标签
 * 所有的setXXX()方法都会在doTag()方法之前被tomcat调用
 * 所在bosy（）中就可以使用tomcat传递过来的对象了
 */

public class CustomizeJspTag implements SimpleTag {
    private PageContext pageContext;
    private JspFragment body;
    @Override
    public void doTag() throws JspException, IOException {
        pageContext.getOut().print("hello tag");

    }

    @Override
    public void setParent(JspTag jspTag) {

    }

    @Override
    public JspTag getParent() {
        return null;
    }

    @Override
    public void setJspContext(JspContext jspContext) {
        this.pageContext = (PageContext) jspContext;

    }

    @Override
    public void setJspBody(JspFragment body) {
        this.body = body;

    }
}
