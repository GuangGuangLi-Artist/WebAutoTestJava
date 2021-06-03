package day23.servletCollections;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Day23ProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/xml;charset=UTF-8");

       
        try {
            SAXReader saxReader = new SAXReader();
            InputStream inputStream = this.getClass().getResourceAsStream("/china.xml");
            Document document = saxReader.read(inputStream);
            
            //查询province的name属性 循环遍历，把所有的属性值连接成一个字符串，发送给客户端
            List<Node> attributeList =  document.selectNodes("//province/@name");
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < attributeList.size(); i++) {
                stringBuilder.append(attributeList.get(i).getStringValue());
                if(i < attributeList.size() - 1){
                    stringBuilder.append(",");
                }
            }
            resp.getWriter().print(stringBuilder);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }


    }
}
