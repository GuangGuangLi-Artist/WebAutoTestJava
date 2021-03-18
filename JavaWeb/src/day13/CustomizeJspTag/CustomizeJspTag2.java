package day13.CustomizeJspTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class CustomizeJspTag2 extends SimpleTagSupport {
    @Override
    public void doTag() throws IOException {
        this.getJspContext().getOut().print("SimpleTagSupport");
    }
}
