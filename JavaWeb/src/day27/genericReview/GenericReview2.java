package day27.genericReview;
/*
    通配符
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericReview2 {
    @Test
    public void fun1(){
        Object[] objects = new Object[10];
        List list = new ArrayList(10);

        String[] strings = new String[10];
        List<String> strings1 = new ArrayList<>();

        Object[] objectArray = new String[10];
        objectArray[0] = new Integer(100);//ArrayStoreException: java.lang.Integer
        //List<Object> objects1 = new ArrayList<String>();
        //objects1.add(new Integer(100));
        /*
        泛型引用和创建两端，给出的泛型变量必须相同
         */

    }

    public void fun2(){
        List<Integer> integerList = new ArrayList<Integer>();
        print(integerList);


        List<String> stringList = new ArrayList<String>();
        print(stringList);
    }

    /*
     * 其中的?就是通配符
     * 通配符只能出现在左边！即不能在new时使用通配符！！！
     * List<?> list = new ArrayList<String>();
     */
    /*
     * ?它表示一个不确定的类型，它的值会在调用时确定下来
     */
    public void print(List<?> list){
        //当使用通配符时，对泛型类中的参数为泛型的方法起到了副作用，不能再使用
        //list.add("hello");

        //当使用通配符时，泛型类中的返回值为泛型的方法，也作废了
        Object s = list.get(0);
        //通配符的好处：可以使泛型类更加通用，尤其是在方法调用时形参使用通配符
    }

    public void fun3(){
        List<Integer> integerList = new ArrayList<Integer>();
        print1(integerList);

        List<Long> longList = new ArrayList<Long>();
        print1(longList);
    }


    /*
        给通配符添加了限定
        只能传递Number或其子类型
        子类通配符对通用性产生了影响，但使用形参更加灵活
     */
    public void print1(List<? extends Number> list){

        //参数为泛型的方法还是不能调用
        //list.add(new Integer(100));

        //返回值为泛型的方法可以使用了
        Number number = list.get(0);
    }


    public void fun4(){
        List<Integer> integerList = new ArrayList<>();
        print2(integerList);


        List<Number> numberList = new ArrayList<>();
        print2(numberList);


        List<Object> objectList = new ArrayList<>();
        print2(objectList);
    }
    /*
        给通配符添加了限定
            只能传递Interget类型或者其父类型
     */

    public void print2(List<? super Integer> list){

        //参数为泛型的方法可以使用了
        list.add(new Integer(100));

        //返回值为泛型的方法却不能使用
        Object obj = list.get(0);
    }

}
