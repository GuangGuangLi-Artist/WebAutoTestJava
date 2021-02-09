package day05.StudentManage;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class StuService {

    //增加
    public static void addStu(Student student) throws DocumentException, IOException {
        //创建解析器
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day05\\StudentManage\\Student.xml");

        //得到根节点
        Element root = document.getRootElement();

        //跟节点添加stu
        Element stu = root.addElement("stu");

        //添加节点
        Element id1 = stu.addElement("id");
        Element name1 = stu.addElement("name");
        Element age1 = stu.addElement("age");

        //在节点上添加值
        id1.setText(student.getId());
        name1.setText(student.getName());
        age1.setText(student.getAge());

        //回写xml
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day05\\StudentManage\\Student.xml"),format);
        xmlWriter.write(document);
        xmlWriter.close();




    }

    //删除

    public static void deleteStu(String id) throws DocumentException, IOException {
        //创建解析器
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day05\\StudentManage\\Student.xml");


        //得到所有的id
        List<Node> listId = document.selectNodes("//id");
        for (Node idNode:listId){
            String idValue = idNode.getText();
            //判断删除
            if(idValue.equals(id)){
                //获取idValue的父亲节点
                Element stu = idNode.getParent();
                Element Student = stu.getParent();
                //删除stu
                Student.remove(stu);

            }
        }

        //回写xml
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day05\\StudentManage\\Student.xml"),format);
        xmlWriter.write(document);
        xmlWriter.close();


    }


    //查询

    public static Student getStu(String id) throws DocumentException {
        //创建解析器
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day05\\StudentManage\\Student.xml");


        //得到所有的id
        List<Node> listId = document.selectNodes("//id");
        //创建Student对象
        Student s = new Student();
        for (Node idNode:listId){
            String idValue = idNode.getText();
            //判断删除
            if(idValue.equals(id)){
                //获取idValue的父亲节点
                Element stu = idNode.getParent();
               //通过stu获取name和age
                String namev = stu.element("name").getText();
                String agev = stu.element("age").getText();
                s.setId(id);
                s.setAge(agev);
                s.setName(namev);

            }
        }

        return s;


    }
}
