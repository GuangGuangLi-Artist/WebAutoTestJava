package day17.cn.itcast.usermng.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {

    private static Properties properties = null;
    static {
        //加载配置文件到props对象中

        try {
            InputStream inputStream = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 返回一个具体的UserDao的实现类对象
     */
    public static UserDao getUserDao(){
        /**
         * 给出一个配置文件，文件中给出UserDao接口的实现类名称
         * 我们这个方法，获取实现类的名称，通过反射完成创建对象
         */
        //得到dao实现类的名称
        String daoClassName = properties.getProperty("cn.itcast.usermng.dao.UserDao");

        /*
        通过反射来创建实现类的对象
         */
        try {
            Class clazz = Class.forName(daoClassName);
            return (UserDao)clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
