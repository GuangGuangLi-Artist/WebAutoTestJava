package day06.Dom4jLearn;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Don4jLearn {
    public static void main(String[] args) throws DocumentException, IOException {

        //selectName();
        //selectSon();
        createNode();
    }

    private static void createNode() throws IOException, DocumentException {
        //创建解析器
        SAXReader saxReader = new SAXReader();
        //得到document
        Document document = saxReader.read("E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day05\\XmlLearn\\xmlParse.xml");

        //得到根节点
        Element root = document.getRootElement();

        //得到第一个p1
        Element p1 = root.element("p1");

        //在p1下添加元素
        Element sex1 = p1.addElement("sex");

        //添加sex1的文本
        sex1.setText("man");

        //回写xml
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day05\\XmlLearn\\xmlParse.xml"),format);
        xmlWriter.write(document);
        xmlWriter.close();
    }


    private static  void selectSon() throws DocumentException {
        //创建解析器
        SAXReader saxReader = new SAXReader();
        //得到document
        Document document = saxReader.read("E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day05\\XmlLearn\\xmlParse.xml");

        //得到根节点
        Element root = document.getRootElement();

        //得到第二个p1
        Element p1 = root.elements("p1").get(1);

        //得到第一个p1下面的name元素
        Element name = p1.element("name");

        String sName = name.getText();
        System.out.println(sName);


    }

    private static void selectName() throws DocumentException {
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
