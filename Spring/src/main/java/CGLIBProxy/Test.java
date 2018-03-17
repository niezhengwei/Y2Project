package CGLIBProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by leon on 2018/3/8.
 */
public class Test {
    /*
    * CGLIB动态代理
    * */
    public static void main(String[] args) {
        final SomeserviceImpl someservice=new SomeserviceImpl();
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(someservice.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("===之前===");
                methodProxy.invoke(someservice,objects);
                return null;
            }
        });
        SomeserviceImpl service=( SomeserviceImpl)enhancer.create();
        service.doSome();
    }
}
