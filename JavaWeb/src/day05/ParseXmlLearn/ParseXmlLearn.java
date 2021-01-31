package day05.ParseXmlLearn;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

public class ParseXmlLearn {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        //创建解析器工厂
        //prseMethod();

        //查询单个节点
        //selectSingle();

        //addNode();

        //updateNode();

        //deleteNode();

        listElement();
    }

    public static void listElement() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        //创建解析器
        DocumentBuilder db = dbf.newDocumentBuilder();

        //解析sml返回document

        Document document = db.parse("E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day05\\XmlLearn\\xmlParse.xml");

        list1(document);


    }

    private static void list1(Node node) {

        if(node.getNodeType()==Node.ELEMENT_NODE){
            System.out.println(node.getNodeName());
        }


        NodeList nl = node.getChildNodes();

        for (int i = 0; i <nl.getLength() ; i++) {
            Node node1 = nl.item(i);

            list1(node1);
        }
    }


    public static void deleteNode() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        //创建解析器
        DocumentBuilder db = dbf.newDocumentBuilder();

        //解析sml返回document

        Document document = db.parse("E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day05\\XmlLearn\\xmlParse.xml");

        Node sexNode = document.getElementsByTagName("sex").item(0);

        Node sexParent = sexNode.getParentNode();

        sexParent.removeChild(sexNode);

        TransformerFactory tf  = TransformerFactory.newInstance();
        Transformer trf = tf.newTransformer();
        trf.transform(new DOMSource(document),new StreamResult("E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day05\\XmlLearn\\xmlParse.xml"));


    }

    public static void updateNode() throws ParserConfigurationException, IOException, SAXException, TransformerException {


        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        //创建解析器
        DocumentBuilder db = dbf.newDocumentBuilder();

        //解析sml返回document

        Document document = db.parse("E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day05\\XmlLearn\\xmlParse.xml");

        Node sexNode = document.getElementsByTagName("sex").item(0);

        //修改
        sexNode.setTextContent("women");

        //回写xml
        TransformerFactory tf  = TransformerFactory.newInstance();
        Transformer trf = tf.newTransformer();
        trf.transform(new DOMSource(document),new StreamResult("E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day05\\XmlLearn\\xmlParse.xml"));



    }

    public static void addNode() throws IOException, SAXException, ParserConfigurationException, TransformerException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        //创建解析器
        DocumentBuilder db = dbf.newDocumentBuilder();

        //解析sml返回document

        Document document = db.parse("E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day05\\XmlLearn\\xmlParse.xml");

        //得到p1
        Node p1 = document.getElementsByTagName("p1").item(0);

        //创建标签
        Element sex1 = document.createElement("sex");
        Text text1 = document.createTextNode("man");
        sex1.appendChild(text1);
        p1.appendChild(sex1);


        //回写xml
        TransformerFactory tf  = TransformerFactory.newInstance();
        Transformer trf = tf.newTransformer();
        trf.transform(new DOMSource(document),new StreamResult("E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day05\\XmlLearn\\xmlParse.xml"));


    }

    public static void selectSingle() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        //创建解析器
        DocumentBuilder db = dbf.newDocumentBuilder();

        //解析sml返回document

        Document document = db.parse("E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day05\\XmlLearn\\xmlParse.xml");

        //得到name元素
        String s = document.getElementsByTagName("name").item(0).getTextContent();
        System.out.println(s);


    }

    public static void prseMethod() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        //创建解析器
        DocumentBuilder db = dbf.newDocumentBuilder();

        //解析sml返回document

        Document document = db.parse("E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day05\\XmlLearn\\xmlParse.xml");

        //得到name元素
        NodeList list = document.getElementsByTagName("name");

        for (int i = 0; i <list.getLength() ; i++) {
         Node name1 = list.item(i);//得到每一个name元素
         String s = name1.getTextContent();
         System.out.println(s);
        }
    }

}
