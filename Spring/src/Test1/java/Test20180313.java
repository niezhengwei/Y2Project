import Service.StudentServiceImpl;
import entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by leon on 2018/3/13.
 */
public class Test20180313 {

    //查询所有图书的名字
    @Test
    public void Test01(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextJdbcTemplate.xml");
        StudentServiceImpl users = (StudentServiceImpl)context.getBean("userService");
        List<User> all = users.findAll();
        for (User item:all){
            System.out.println("姓名："+item.getUsername()+"\t"+"密码："+item.getPwd());
        }
    }
}
