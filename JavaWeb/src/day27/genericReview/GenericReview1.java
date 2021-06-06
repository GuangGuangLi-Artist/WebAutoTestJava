package day27.genericReview;

import org.junit.Test;
//泛型

public class GenericReview1 {

    @Test
    public void fun1(){
        AA1 aa1 = new AA1();
        //aa1.fun2();Integer
    }

    @Test
    public void fun2(){
        AA2 aa2 = new AA2();
        //aa2.fun2(); String
    }

    @Test
    public void fun3(){
        AA3<Long> aa3 = new AA3<Long>();
        //aa3.fun2();Long

    }
}

class A<T>{
    private T t;
    public T fun1(){
        return t;
    }

    public void fun2(T t){
        this.t = t;
    }
}

class AA1 extends A<Integer>{}
class AA2 extends A<String>{}

class AA3<E> extends A<E>{}

