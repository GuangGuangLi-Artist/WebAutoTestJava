package day01.JunitDemo;

import org.junit.*;

import java.io.FileInputStream;
import java.io.IOException;

public class JunitDemo2 {


    @BeforeClass
    //@Before
    public  static void beforeRead(){
        System.out.println("准备测试环境成功");
    }


    @Test
    public void readFile() throws IOException {
        FileInputStream fis = new FileInputStream("E:\\崔希凡javaWeb\\day01\\代码\\day01\\src\\cn\\itcsat\\junit\\demo2.java");
        int len = 0;
        while ((len=fis.read()) != -1){
            System.out.print((char)len);
        }

        fis.close();
    }

    @AfterClass
    //@After
    public static void afterRead(){
        System.out.println("清理测试环境成功");
    }
}
