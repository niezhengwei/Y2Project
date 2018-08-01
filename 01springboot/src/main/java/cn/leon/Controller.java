package cn.leon;

import cn.leon.entity.Users;
import cn.leon.service.IUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by leon on 2018/6/29.
 */

@RestController
public class Controller {

    @Value("${cn.leon.name}")
    private String name;

    @Resource(name = "userservice")
    private IUserService userService;

    @RequestMapping("/getName")
    @ResponseBody
    public String First(){
        return name;

    }

    @RequestMapping("/getData")
    @ResponseBody
    public Object getData(){
        Demo demo=new Demo();
        demo.setId(1);
        demo.setName("聂正伟");
        demo.setCreatetime(new Date());
        return demo;
    }

    @RequestMapping("/new")
    public String insert(){
        Users users=new Users();
        users.setUsername("leon");
        users.setPassword("123456");
        users.setRealname("聂正伟");
        userService.save(users);
        return "add ok";
    }


}
