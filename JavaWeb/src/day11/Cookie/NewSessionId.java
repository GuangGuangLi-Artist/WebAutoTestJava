package day11.Cookie;

import org.junit.Test;

import java.util.UUID;

public class NewSessionId {




    public String commonSessionID(){
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }


    @Test
    public void fun1(){
        String sessionId = UUID.randomUUID().toString().replace("-","").toUpperCase();
        System.out.println(sessionId);
    }

}
