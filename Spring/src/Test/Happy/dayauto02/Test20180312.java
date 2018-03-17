package dayauto02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by leon on 2018/3/12.
 */
public class Test20180312 {
     //名称自动代理
    @Test
    public  void Test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextdayauto02.xml");
        SomeBefore service = (SomeBefore)context.getBean("service");
        service.doSome();
        service.doGet();
        service.sayhi();
    }
}
