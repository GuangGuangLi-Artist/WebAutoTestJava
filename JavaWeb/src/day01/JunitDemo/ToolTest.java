package day01.JunitDemo;

import org.junit.Assert;
import org.junit.Test;

public class ToolTest {

    @Test
    public void testGetMax(){
        int max  = Tool.getMax();
      /*  if(max != 5){
            throw new RuntimeException();
        }else {
            System.out.println("最大值： " + max);
        }*/

        Assert.assertSame(5,max);
        Assert.assertEquals(new String("abc"),"abc");
    }

    @Test
    public void testGetMin(){
        int min = Tool.getMin();
        Assert.assertSame(8,min);
    }
}
