package day17.cn.itcast.usermng.dao;

import day17.cn.itcast.usermng.domain.User;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * 数据类
 */
public class UserDaoImple implements UserDao {
    private String path = "E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day14\\users.xml";//依赖数据文件

    public User findByUsername(String username){
        /*
            得到document
            xpath查询
            校验查询结果是否为null，如果为null 返回null
            如果不为null，需要把Element封装到User中
         */
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(path);
            Element element = (Element) document.selectSingleNode("//user[@username='" + username + "']");
            if(element == null) return null;

            User user = new User();
            String attrUsername = element.attributeValue("username");
            String attrPassword = element.attributeValue("password");
            user.setUsername(attrUsername);
            user.setPassword(attrPassword);
            return user;

        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }

    }

    public void addUser(User user){

        /*
        得到document
        通过document得到root元素
        使用参数user,转换成Element
        把elemrnt添加到root
        保存document
         */
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(path);
            Element root = document.getRootElement();
            Element userEle = root.addElement("usermng");
            userEle.addAttribute("username",user.getUsername());
            userEle.addAttribute("password",user.getPassword());

            OutputFormat format = new OutputFormat("\t",true);
            format.setTrimText(true);//清空原有的换行和缩进

            //创建XmlWrite
//            XMLWriter xmlWriter = new XMLWriter(new FileWriter(path),format);
            XMLWriter xmlWriter = null;
            try {
                xmlWriter = new XMLWriter(new OutputStreamWriter(new FileOutputStream(path),"UTF-8"),format);
                xmlWriter.write(document);
                xmlWriter.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }


    }

}
