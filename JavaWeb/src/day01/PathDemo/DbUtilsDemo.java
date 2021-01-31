package day01.PathDemo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbUtilsDemo {
    static Properties properties;

    static {
        try {
            properties = new Properties();
            //加载配置文件
            //properties.load(new FileReader("E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day01\\PathDemo\\PathDemo"));

            Class clazz = DbUtilsDemo.class;
            InputStream inputStream = clazz.getResourceAsStream("/day01/PathDemo/db.properties");//其中name路径就是当前的classPath路径
            properties.load(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("当前路径： " + new File(".").getAbsolutePath());
        System.out.println("用户名: " + properties.getProperty("Username") + " 密码: " + properties.getProperty("PassWord"));
    }
}
