package throwEx;



import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.ThrowsAdvice;

/**
 * Created by leon on 2018/3/8.
 */
public class BeforeTest implements ThrowsAdvice {
    public void afterThrowing(Exception ex){
        System.out.println("异常出现了!!!");
    }

}
