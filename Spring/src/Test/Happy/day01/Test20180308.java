package day01;
import day01.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by leon on 2018/3/8.
 */
public class Test20180308 {
    //正则方法切面顾问
    @Test
    public void Test02(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextday01.xml");
        SomeBefore services = (SomeBefore)context.getBean("advisors");
        services.sayhi();
        services.doSome();
        services.doGet();


    }
}
