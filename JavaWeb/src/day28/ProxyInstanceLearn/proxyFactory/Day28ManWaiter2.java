package day28.ProxyInstanceLearn.proxyFactory;

public class Day28ManWaiter2 implements Day28Waier2{
    @Override
    public void serve() {
        System.out.println("服务员2服务中");
    }

    @Override
    public void shouQian() {
        System.out.println("请给钱啊");

    }
}
