package day21.SolveGarbled.SolveGarbledFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

/*
    装饰request
 */
public class EncodingRequest extends HttpServletRequestWrapper {
    private HttpServletRequest req;
    public EncodingRequest(HttpServletRequest request){
        super(request);
        this.req = request;
    }

    public String getParamter(String name){
        String value = req.getParameter(name);

        //处理编码问题

        try {
            value = new String(value.getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        return value;

    }
}
