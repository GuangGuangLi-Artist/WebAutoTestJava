package day01.IntrospectionDemo;
/*
    内省  ---> 一个变态的反射
    内省  主要解决的问题：把对象的属性数据封装到对象中
 */

import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class IntrospectorDemo {


    @Test
    public void getAllProperty() throws IntrospectionException {
        //Introspector 内省类
        BeanInfo beamInfo = Introspector.getBeanInfo(Person.class);

        //通过BeanInfo获取所有的属性描述器
        PropertyDescriptor[] descriptors =  beamInfo.getPropertyDescriptors();
        for(PropertyDescriptor descriptor:descriptors){
            System.out.println(descriptor.getReadMethod());//get方法
        }
    }


    @Test
    public void testProperty() throws InvocationTargetException, IllegalAccessException, IntrospectionException {
        Person p = new Person();
        //属性描述器
        PropertyDescriptor pd = new PropertyDescriptor("id",Person.class);
        //获取属性对应的get或者set方法设置或者设置属性
        Method m = pd.getWriteMethod();//获取set方法

        //执行该方法设置属性
        m.invoke(p,123);

        Method readMethod = pd.getReadMethod();
        System.out.println(readMethod.invoke(p,null));
    }
}
