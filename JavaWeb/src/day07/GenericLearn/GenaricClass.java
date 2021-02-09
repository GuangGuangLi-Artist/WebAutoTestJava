package day07.GenericLearn;

public class GenaricClass<T> {

    //在类里面可以直接使用T的类型
    T aa;
    public void test1(T bb){
        System.out.println("泛型类");
    }

    //写一个静态的方法，在类上面定义的泛型，不能在静态方法里面直接使用
    public static <A> void test2(A cc){
        System.out.println("静态方法中不能使用类上面定义的泛型，如果要使用，需要单独定义");
    }


}
