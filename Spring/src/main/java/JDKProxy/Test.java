package JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by leon on 2018/3/8.
 */
public class Test {
    /*
    * JDK动态代理
    * */
    public static void main(String[] args) {
        final ISomeservice service=new ISomeserviceImpl();
        ISomeservice oo =(ISomeservice) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before=======");
                method.invoke(service);
                return null;
            }
        });
        oo.doSome();
    }
}
