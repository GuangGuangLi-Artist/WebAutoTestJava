package day27.annotationLearn;


@MyAnnotatio1(
        a=100,
        b="hello",
        c=MyEnum1.A,
        d=String.class,
        e=@MyAnnotatio2(value = 20,age = 30),
        f={100,200}
)
public class AnnotationDemo1 {

    //在类上使用注解
}


//注解的格式
@interface MyAnnotatio1{

    //注解的8种属性类型
    int a();
    String b();
    MyEnum1 c();
    Class d();
    MyAnnotatio2 e();
    int [] f();
}


enum  MyEnum1{
    A, B, C
}

@interface MyAnnotatio2{
    int value();
    int age();
    String name() default "Wangwu";

}

