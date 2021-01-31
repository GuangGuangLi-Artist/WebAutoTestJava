package day01.IntrospectionDemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/*
    需求： 编写一个工厂方法根据配置文件的内容，工厂方法返回对应的对象，并且把对象要有对应的属性值。
 */
public class FansheDemo {


    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Person p = (Person) getInstance();
        System.out.println(p);
    }

    //根据配置文件的内容生产对象的对象并且要把对象的属性值封装到对象中
    public static Object getInstance() throws IOException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        BufferedReader br = new BufferedReader(new FileReader("E:\\ideaworkspace\\WebAutoTestJava\\JavaWeb\\src\\day01\\IntrospectionDemo\\properties.txt"));
        String className = br.readLine();//读取配置文件中的完整类名
        Class clazz = Class.forName(className);

        //通过class对象获取到无参的构造方法
        Constructor constructor = clazz.getConstructor(null);

        //创建对象
        Object o = constructor.newInstance(null);

        //读取属性值
        String line = null;
        while ((line=br.readLine()) != null){
            String [] datas = line.split("=");

            //通过属性名获取到对应的Field对象。
            Field field = clazz.getDeclaredField(datas[0]);
            field.setAccessible(true);
            if(field.getType() == int.class){
                field.set(o,Integer.parseInt(datas[1]));
            }else {
                field.set(o,datas[1]);
            }
        }

        return o;


    }

}
