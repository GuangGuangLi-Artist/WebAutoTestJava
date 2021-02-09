package day07.GenericLearn;

import java.util.Arrays;

public class GenericMethod {
    public static void main(String[] args) {
        //实现一个泛型方法，实现数组中指定位置元素位置的互换
        Integer [] arr = {11,22,33,44,55};
        System.out.println("交换前：" + Arrays.toString(arr));
        exchangeMethod(arr,1,3);
        System.out.println("交换后：" + Arrays.toString(arr));

        System.out.println("-----------------");

        String [] arrStr = {"aa","bb","cc","dd","ee"};
        System.out.println("交换前：" + Arrays.toString(arrStr));
        exchangeMethod(arrStr,1,3);
        System.out.println("交换后：" + Arrays.toString(arrStr));


    }

    private static<T> void exchangeMethod(T[] arr, int a, int b) {

       /*
       使用泛型方法 需要定义一个类型 使用大写字母表示 T :这个T表示任意的类型
        写在返回值之前  void之前 <T>
        表示定义了一个类型 这个类型是 T
        在下面就可以使用这个类型了  T
        */

        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
