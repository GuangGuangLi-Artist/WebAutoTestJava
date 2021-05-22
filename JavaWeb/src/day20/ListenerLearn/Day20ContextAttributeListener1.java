package day20.ListenerLearn;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class Day20ContextAttributeListener1 implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("您向application中添加一个名为" + scae.getName() + " , 值为： " + scae.getValue() + "的属性");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println(scae.getName()  + "=" + scae.getValue() + "," +
                scae.getServletContext().getAttribute(scae.getName()));

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println(scae.getName() + "=" + scae.getValue());

    }
}
