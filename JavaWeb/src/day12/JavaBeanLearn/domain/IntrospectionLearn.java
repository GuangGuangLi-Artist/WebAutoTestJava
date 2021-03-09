package day12.JavaBeanLearn.domain;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class IntrospectionLearn {

    /**
     * 内省
     *  内省类---Bean信息---属性描述符---属性的get/set对应的method----可以反射了
     *
     */

    @Test
    public void funIntrospection() throws Exception {
        String className = "day12.JavaBeanLearn.domain.Person";
        Class clazz = Class.forName(className);
        Object bean = clazz.newInstance();

        //使用Beanutils的内省
        BeanUtils.setProperty(bean,"name","里哈哈");
        BeanUtils.setProperty(bean,"age","20");
        BeanUtils.setProperty(bean,"number","20120118");

        //获取值打印
        System.out.println(bean);

        //设置值和读取值
        String name = BeanUtils.getProperty(bean,"name");
        System.out.println(name);
    }


    /**
     * 把map中的属性直接封装到bean中
     * Map:{"userName":"苏彪","passWord":"123456"}
     * 如果我们要把map的数据封装到一个JavaBean中，要求map的key与bean的属性名相同
     */

    @Test
    public void fun2Introspection() throws Exception {
        //新建map
        Map<String,String> map = new HashMap<>();
        map.put("userName","苏彪");
        map.put("passWord","123456");

        //获取bean
        User user = new User();

        //封装数据
        BeanUtils.populate(user,map);

        System.out.println(user);
    }



    @Test
    public void fun3Introspection(){
        Map<String,String> map = new HashMap<>();
        map.put("userName","苏彪");
        map.put("passWord","123456");

        User user = CommonUtils.toBean(map,User.class);
        System.out.println(user);
    }
}
