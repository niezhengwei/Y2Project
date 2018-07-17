package cn.leon.Controller;

import cn.leon.entity.Users;
import cn.leon.service.ILoginService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;
import java.text.SimpleDateFormat;

/**
 * Created by leon on 2018/7/17.
 */
@Controller
public class LoginController {

    @Resource(name = "loginservice")
    private ILoginService loginService;

    @RequestMapping("/loginmain")
    public String login(){
        return  "login";
    }

    @RequestMapping("/loginuser")
    public String loginUser(String name, String password, HttpSession session){
        System.out.println(name);
        System.out.println(password);
        Users login = loginService.login(name, password);
        session.setAttribute("login",login);
        System.out.println(login);
        if(login!=null){
            return "loginIndex";

        }else{
            return "login";
        }
    }

    @RequestMapping("/updateUser")
    public Object updateUsers(String password,String passwords,Integer ids,HttpSession session){
        System.out.println(password);
        System.out.println(ids);
        System.out.println(passwords);
        Users login = (Users) session.getAttribute("login");
        if(login.getPassword()==password){
            System.out.println("密码一致");
            if(password==passwords){
                System.out.println("两次输入密码不一致!");
            }
        }else{
            loginService.updateUser(password,ids);
            System.out.println("修改成功!");
            return "forward:/loginmain";
        }
        return null;
    }

    @RequestMapping("/FindAlllistUser")
    @ResponseBody
    public Object saleList(@RequestParam(value="name", defaultValue="小")String name, @RequestParam(required = false, defaultValue="1")int pageNum, @RequestParam(required = false, defaultValue="5")int pageSize)
    {
        System.out.println(name+"===========>name");
        System.out.println(pageNum+"============>"+pageNum);
        PageInfo<Users> usersPageInfo = loginService.findAllUser(name, (pageNum+1), pageSize);

        System.out.println("当前页数"+usersPageInfo.getPageNum());
        System.out.println("记录数："+usersPageInfo.getSize());
        for (Users u : usersPageInfo.getList())
        {
            System.out.println("查询出来的id:"+u.getId());

        }
        return usersPageInfo;
    }


    @RequestMapping("/exit")
    public String exits(HttpSession session) {
        session.removeAttribute("login");
        return "forward:/loginmain";
    }
}
