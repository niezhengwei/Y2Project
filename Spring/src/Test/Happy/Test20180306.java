import BeforeAdvice.SomeBefore;
import Subject.ProxySubject;
import Subject.Zsubject;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by leon on 2018/3/6.
 */
public class Test20180306 {
    //静态代理
    @Test
    public void Test01(){
        //真实主题
        Zsubject zu=new Zsubject();
        //代理主题
        ProxySubject pro=new ProxySubject();

        pro.setZsubject(zu);
        pro.request();

    }
    /*
    * 前置增强
    * */
    @Test
    public void Test02(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext07.xml");
        BeforeAdvice.SomeBefore bean =(BeforeAdvice.SomeBefore) context.getBean("proxy");
        bean.sayhi();

    }
    @Test
    public void Test03(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext08.xml");
        Inectoper.SomeBefore bean =(Inectoper.SomeBefore) context.getBean("proxys");
        bean.sayhi();
    }
}
