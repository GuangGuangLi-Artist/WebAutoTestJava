package day28.ProxyInstanceLearn.mustGrasp;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Day28ProxyinstanceLearn2 {

    @Test
    public void fun2(){

        Day28Watier day28ManWatier = new Day28ManWaier();//目标对象
        //给出三个参数，来创建方法，得到代理对象

        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<Day28Watier> interfaces = (Day28Watier.class);
        InvocationHandler invocationHandler = new Day28WaiterInvocationHandler(day28ManWatier);//参数day28ManWatier表示目标对象

        //得到代理对象，代理对象就是在目标对象的基础上进行了增强的对象
        Day28Watier day28WatierProxy = (Day28Watier) Proxy.newProxyInstance(classLoader, new Class[]{interfaces},invocationHandler);

        day28WatierProxy.serve();



    }
}


class Day28WaiterInvocationHandler implements InvocationHandler{

    private Day28Watier day28Watier;//目标对象

    public Day28WaiterInvocationHandler(Day28Watier day28Watier){
        this.day28Watier = day28Watier;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("您好");
        this.day28Watier.serve();
        System.out.println("再见");
        return null;
    }
}
