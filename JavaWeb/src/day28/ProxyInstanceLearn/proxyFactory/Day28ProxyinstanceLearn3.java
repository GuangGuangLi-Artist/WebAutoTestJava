package day28.ProxyInstanceLearn.proxyFactory;

import org.junit.Test;

public class Day28ProxyinstanceLearn3 {

    @Test
    public void fun3(){
        ProxyFactory proxyFactory = new ProxyFactory();//创建工厂
        proxyFactory.setTargetObject(new Day28ManWaiter2());//设置目标对象
        proxyFactory.setBeforeAdvice(new BeforeAdvice() {//设置前置增强
            @Override
            public void before() {
                System.out.println("您好不好");
            }
        });

        proxyFactory.setAfterAdvice(new AfterAdvice() {
            @Override
            public void after() {
                System.out.println("再见不见");
            }
        });

        Day28Waier2 day28ManWaier2 = (Day28Waier2) proxyFactory.createProxy();
        day28ManWaier2.shouQian();
    }
}
