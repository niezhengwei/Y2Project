package dayauto02;



import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by leon on 2018/3/8.
 */
public class BeforeTest implements MethodBeforeAdvice {
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("===before====");
    }
}
