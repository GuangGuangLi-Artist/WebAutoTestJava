package day05.StudentManage;

import org.dom4j.DocumentException;

import java.io.IOException;

public class UseStuService {
    public static void main(String[] args) throws IOException, DocumentException {
        //testAdd();
        //testDel();

        testSelectStu();


    }

    private static void testSelectStu() throws DocumentException {
        Student student =  StuService.getStu("100");
        System.out.println(student);
    }

    private static void testDel() throws IOException, DocumentException {
        StuService.deleteStu("300");
    }

    private static void testAdd() throws IOException, DocumentException {
        Student s = new Student("300","wangwu","15");
        StuService.addStu(s);

    }


}
