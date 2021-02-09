package day05.XpathLearn;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.List;

public class XpathLearn {
    public static void main(String[] args) throws DocumentException {
        //查询所有name元素的值
        //getAllName();
        getFirstName();


    }

    private static void getFirstName() throws DocumentException {
        //创建解析器
        SAXReader saxReader = new SAXReader();
        //得到document
        Document document = saxReader.read("E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day05\\XmlLearn\\xmlParse.xml");

        //获取单个节点
        Node namedNode = document.selectSingleNode("//p1[@id1='aaa']/name");

        String nameText = namedNode.getText();
        System.out.println(nameText);


    }

    private static void getAllName() throws DocumentException {
        //创建解析器
        SAXReader saxReader = new SAXReader();
        //得到document
        Document document = saxReader.read("E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day05\\XmlLearn\\xmlParse.xml");

        List<Node> nameList =  document.selectNodes("//name");
        for(Node name:nameList){
            String nameValue = name.getText();
            System.out.println(nameValue);
        }
    }
}
