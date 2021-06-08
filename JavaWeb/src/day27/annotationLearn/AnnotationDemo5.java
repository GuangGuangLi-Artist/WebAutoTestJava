package day27.annotationLearn;

import org.junit.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class AnnotationDemo5 {

    @Test
    public void testDay27Fun1(){
        //得到作用目标
        Class<Day27A> c = Day27A.class;

        //获取指定类型的注解
        MyAnnotation5 myAnnotation5 = c.getAnnotation(MyAnnotation5.class);

        System.out.println(myAnnotation5.name() + "," + myAnnotation5.age() + "," + myAnnotation5.sex());
    }



    @Test
    public void testDay27Fun2() throws NoSuchMethodException {
        //得到作用目标
        Class<Day27A> c = Day27A.class;
        Method method =  c.getMethod("day27A");

        //获取指定类型的注解
        MyAnnotation5 myAnnotation5 = method.getAnnotation(MyAnnotation5.class);

        System.out.println(myAnnotation5.name() + "," + myAnnotation5.age() + "," + myAnnotation5.sex());
    }





}



@MyAnnotation5(name="A类",age=1,sex = "male")
class Day27A{

    @MyAnnotation5(name = "A方法",age = 2,sex = "female")
    public void day27A(){

    }

}

//定义注解
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation5{
    String name();
    int age();
    String sex();
}
