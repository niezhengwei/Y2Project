package day02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by leon on 2018/3/8.
 */
public class Test20180308 {
   //自动代理
    @Test
    public void Test02(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextday02.xml");
        SomeBefore services =(SomeBefore)context.getBean("service");
        services.sayhi();
        services.doSome();
        services.doGet();
    }

    //AspectJ注解  前置  后置  环绕  异常 最终  增强
    @Test
    public void Test03(){
       ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextdayaspect.xml") ;
        DemoAspect.SomeBefore service = (DemoAspect.SomeBefore)context.getBean("service");
      service.Ends();
    }

    //aspectJ xml版本
    @Test
    public void Test04(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextdayaspectxml.xml") ;
        DamoAspectXml.SomeBefore service = (DamoAspectXml.SomeBefore)context.getBean("service");
        service.doGet();
        service.doSome();
    }
}
