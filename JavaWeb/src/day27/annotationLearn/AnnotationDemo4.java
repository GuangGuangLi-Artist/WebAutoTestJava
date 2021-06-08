package day27.annotationLearn;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class AnnotationDemo4 {

    @Test
    public void fun1(){
        new B();
    }

    @Test
    public void fun2(){
        new C();
    }
}

abstract class A<T>{
    public A() {
        /*
            在这里获取子类传递的泛型信息，要得到一个class
         */

        Class clazz = this.getClass();//得到子类的类型
        Type type = clazz.getGenericSuperclass();//获取到传递给父类的参数化信息
        ParameterizedType parameterizedType = (ParameterizedType)type;//它就是A<String>
        Type[] types = parameterizedType.getActualTypeArguments();//它就是Class数组
        Class c = (Class)types[0];
        System.out.println(c.getName());
        System.out.println("=========连写版==========");

        Class c1 = (Class)((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
        System.out.println(c1);
    }
}

class B extends  A<String>{

}

class C extends A<Integer>{

}
