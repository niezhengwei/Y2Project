package Inectoper;



import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * Created by leon on 2018/3/8.
 */
public class BeforeTest implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("我在上");
        methodInvocation.proceed();
        System.out.println("我在下");
        return null;
    }
}
