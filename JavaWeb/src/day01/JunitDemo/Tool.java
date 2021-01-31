package day01.JunitDemo;

public class Tool {

    public static int  getMax(){
        int a = 3;
        int b = 5;
        int max = a > b ? a : b;
        return max;
    }

    public  static int getMin(){
        int a = 8;
        int b = 10;
        int min = a < b ? a : b;
        return min;
    }
}
