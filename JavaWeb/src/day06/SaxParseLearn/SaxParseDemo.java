package day06.SaxParseLearn;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxParseDemo {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {


        //创建解析器工厂
        SAXParserFactory spf = SAXParserFactory.newInstance();

        //创建解析器
        SAXParser sp = spf.newSAXParser();

        //执行parses方法
        sp.parse("E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day05\\XmlLearn\\xmlParse.xml",new MyDefault1());
    }
}

class MyDefault1 extends DefaultHandler{
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //super.startElement(uri, localName, qName, attributes);
        System.out.print("<" + qName + ">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //super.endElement(uri, localName, qName);
        System.out.print("</" + qName + ">");


    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //super.characters(ch, start, length);
        System.out.print(new String(ch,start,length));
    }
}
