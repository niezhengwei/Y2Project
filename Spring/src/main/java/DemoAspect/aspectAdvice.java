package DemoAspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by leon on 2018/3/12.
 */
@Aspect
public class aspectAdvice {
/*    //前置增强
    @Before("execution(* DemoAspect.*.doSome(..))")
    public void myBefore(){
        System.out.println("===before===");
    }
    //后置增强
    @AfterReturning("execution(* DemoAspect.*.doGet(..))")
    public void myAfter(){
        System.out.println("===end===");
    }*/
    //环绕增强
    @Around("execution(* DemoAspect.*.sayhi(..))")
    public void myArpund(ProceedingJoinPoint point) throws Throwable {
        System.out.println("我在上边");
        point.proceed();
        System.out.println("我在下边");
    }
    //异常增强
    @AfterThrowing("execution(* DemoAspect.*.doSome(..))")
    public void MyThrowing(){
        System.out.println("异常出现了！");
    }
    //最终增强
    @After("execution(* DemoAspect.*.Ends(..))")
    public void MyEnd(){
        System.out.println("我是最终增强");
    }
}
