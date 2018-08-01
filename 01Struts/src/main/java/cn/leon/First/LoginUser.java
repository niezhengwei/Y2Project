package cn.leon.First;

import cn.leon.entity.User;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by leon on 2018/6/11.
 */
public class LoginUser extends ActionSupport {
    private User user;

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String loginUser(){
        System.out.println("这里是登陆方法");
        System.out.println("用户名是："+user.getUserName());
        System.out.println("用户的密码是："+user.getPassword());
        return SUCCESS;
    }

}
