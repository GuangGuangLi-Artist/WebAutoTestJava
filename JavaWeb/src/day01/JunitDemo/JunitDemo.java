package day01.JunitDemo;

import org.junit.Test;

import java.util.Arrays;

public class JunitDemo {

    @Test
    public void getMax(){
        int a = 5;
        int b = 8;
        int res = a > b ? a : b;
        System.out.println("最大值是：" + res);

    }

    @Test
    public void sortDemo() {
        int[] arr = {12,4,1,19};
        for (int i = 0; i <arr.length - 1 ; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("数组的元素： " + Arrays.toString(arr));
    }


}
