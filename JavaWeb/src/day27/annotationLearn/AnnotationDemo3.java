package day27.annotationLearn;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@MyAnnotation4
public class AnnotationDemo3 {

    //注解的保留策略
    /*
     * 源代码文件（SOURCE）：注解只在源代码中存在，当编译时就被忽略了
     * 字节码文件（CLASS）：注解在源代码中存在，然后编译时会把注解信息放到了class文件，但JVM在加载类时，会忽略注解！
     * JVM中（RUNTIME）：注解在源代码、字节码文件中存在，并且在JVM加载类时，会把注解加载到JVM内存中（它是唯一可反射注解！）
     */
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation4{
    int value() default 300;
}
