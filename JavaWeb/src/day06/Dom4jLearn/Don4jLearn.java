package day06.Dom4jLearn;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Don4jLearn {
    public static void main(String[] args) throws DocumentException {


        //创建解析器

        SAXReader saxReader = new SAXReader();
        //得到document
        Document document = saxReader.read("E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day05\\XmlLearn\\xmlParse.xml");

        //得到根节点
        Element root = document.getRootElement();

        //得到p1
        List<Element> list = root.elements("p1");
        for(Element element:list){
            //得到p1下的name
            Element name1 = element.element("name");
            //得到name的值
            String name = name1.getText();

            System.out.println(name);
        }
    }
}
