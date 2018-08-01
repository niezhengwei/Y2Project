package cn.leon.First;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by leon on 2018/6/13.
 */
public class ActionInfo extends ActionSupport implements SessionAware {

    private Map<String, Object> session;

    public String add(){
        System.out.println("进入了add方法");
        return SUCCESS;
    }
    public String delete(){
        System.out.println("进入了delete方法");
        return SUCCESS;
    }
    public String update(){
        System.out.println("进入了update方法");
        return SUCCESS;
    }
    public String find(){
        System.out.println("进入了find方法");
        return SUCCESS;
    }

    public String login(){
        System.out.println("进入了login方法");
        session.put("logins","目的地");
        return SUCCESS;
    }

    //通过session将后台数据传入到jsp页面
  @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }

    public String login1(){
        System.out.println("进入了login1方法");
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("login1","目的地2");
        return SUCCESS;
    }

}
