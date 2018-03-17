import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import throwEx.SomeBefore;
import advisor.*;
/**
 * Created by leon on 2018/3/8.
 */
public class Test20180308 {
    @Test
    public void Test01(){

        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext09.xml");
        throwEx.SomeBefore proxys =(throwEx.SomeBefore) context.getBean("proxys");
        try{
            proxys.sayhi();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void Test02(){

        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext10.xml");
        advisor.SomeBefore proxys =(advisor.SomeBefore) context.getBean("advisors");
        proxys.doSome();
    }
}
