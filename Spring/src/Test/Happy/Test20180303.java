import MyCollection.collection;
import happy.HappyService;
import happy.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import printer.Printer;
import service.IHelloService;

/**
 * Created by leon on 2018/3/3.
 */
public class Test20180303 {

    //第一个案例
    @Test
public void Test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
      HappyService service = (HappyService)context.getBean("service");
        System.out.println(service.getAge());
    }
    //打印机案例
    @Test
    public void Test01(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext01.xml");
        Printer printer = (Printer)context.getBean("printer");
        printer.print();
    }
    //汽车案例
    @Test
    public void Test02(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext02.xml");
        Student student =(Student) context.getBean("Student");
        System.out.println(student.getName()+"开着"+student.getCar().getBrand()+","+"走在街上");
    }
    //AOP
    @Test
    public void Test03(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext04Aop.xml");
        IHelloService service = (IHelloService)context.getBean("service");
        service.some();
    }
    //集合注入
    @Test
    public void Test04(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext05.xml");
/*        collection mycollection =(collection) context.getBean("mycollection");
        System.out.println(mycollection);*/
    }

    //自动配置
    @Test
    public void Test05(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext02.xml");
        Student student =(Student) context.getBean("student");
        System.out.println(student);
    }

    //注解
    @Test
    public void Test06(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext06.xml");
        Student student =(Student) context.getBean("student");
        System.out.println(student);
    }

}
