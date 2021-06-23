package day28.ProxyInstanceLearn;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInstanceLearn1 {



    @Test
    public void fun1(){
        /**
         * 三大参数
         * 1：ClassLoader
         * 方法需要动态生成一个类，这个类实现了A,B接口，然后创建这个类的对象
         * 需要生成一个类，这个类也需要加载到方法区中，谁来加载，当然是ClassLoader
         *
         * 2：Class[] interfaces
         * 它是实现的接口们
         *
         * 3：InvocationHandler
         * 它是调用处理器
         * 敷衍它
         *
         * 代理对象的实现的所有接口中的方法，内容都是调用InvocationHandler的invoke()方法

         */

        ClassLoader classLoader = this.getClass().getClassLoader();
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("你好，动态代理");
                return "xxx";
            }
        };

        //使用三大参数创建代理对象
        Object obj = Proxy.newProxyInstance(classLoader,new Class[]{A.class,B.class},h);

        A a = (A) obj;
        B b = (B) obj;


        Object res = a.aaa("hello",100);
        System.out.println(res);

    }
}

interface A{
    public void a();
    public void  aa();
    public Object aaa(String a, int i);
}

interface B{
    public void b();
    public void  bb();
}