package day28.ProxyInstanceLearn.proxyFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory  {
    private Object targetObject;//目标对象
    private BeforeAdvice beforeAdvice;//前置增强
    private AfterAdvice afterAdvice;//后置增强

    public Object getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(Object targetObject) {
        this.targetObject = targetObject;
    }

    public BeforeAdvice getBeforeAdvice() {
        return beforeAdvice;
    }

    public void setBeforeAdvice(BeforeAdvice beforeAdvice) {
        this.beforeAdvice = beforeAdvice;
    }

    public AfterAdvice getAfterAdvice() {
        return afterAdvice;
    }

    public void setAfterAdvice(AfterAdvice afterAdvice) {
        this.afterAdvice = afterAdvice;
    }

    //生成代理对象
    public Object createProxy(){

        //给出三大参数
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class[] interfaces = targetObject.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //在调用代理对象的方法时会执行这里的内容
                //执行前置增强
                if(beforeAdvice != null){
                    beforeAdvice.before();
                }

                Object res = method.invoke(targetObject,args);

                //后置增强
                if(afterAdvice != null){
                    afterAdvice.after();
                }

                //返回目标对象的返回值
                return res;
            }
        };

        Object proxyObject = Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
        return proxyObject;
    }
}
