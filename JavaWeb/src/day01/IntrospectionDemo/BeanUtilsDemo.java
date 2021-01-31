package day01.IntrospectionDemo;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;


import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BeanUtilsDemo {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        //从文件读取到的数据都是字符串的数据，或者是表单提交的数据获取到的时候也是字符串的数据
        String id = "111";
        String name = "梅长苏";
        String salary = "1000.8";
        String birthday = "2013-12-10";


        //注册一个类型转换器
        ConvertUtils.register(new Converter() {
            @Override
            public Object convert(Class type, Object value) {
                Date date = null;
                try{
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    date = dateFormat.parse((String)value);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return date;
            }
        },Date.class);

        Emp e = new Emp();
        BeanUtils.setProperty(e,"id",id);
        BeanUtils.setProperty(e,"name",name);
        BeanUtils.setProperty(e,"salary",salary);
        BeanUtils.setProperty(e,"birthday",birthday);
        System.out.println(e);
    }

}
