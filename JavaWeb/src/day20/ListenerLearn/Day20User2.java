package day20.ListenerLearn;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class Day20User2 implements HttpSessionActivationListener,java.io.Serializable {
    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("session被存到硬盘了");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("session被反序列化成功");

    }
}
