package day27.annotationLearn;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;


@MyAnnotation3(200)
public class AnnotationDemo2 {

    //注解的作用目标限定
    //让一个注解，它的作用目标只能在类上，不能在方法上，这就叫作用目标的限定！

}

@Target(value = {ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
@interface MyAnnotation3{
    int value();
}
