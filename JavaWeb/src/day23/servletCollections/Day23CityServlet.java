package day23.servletCollections;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Day23CityServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        try {
            SAXReader saxReader = new SAXReader();
            InputStream inputStream = this.getClass().getResourceAsStream("/china.xml");
            Document document = saxReader.read(inputStream);

            String pname = req.getParameter("pname");
            Element proElement = (Element) document.selectSingleNode("//province[@name='" + pname + "']");
            String xmlStr = proElement.asXML();//把元素转换成字符串
            resp.getWriter().print(xmlStr);

        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }
}
