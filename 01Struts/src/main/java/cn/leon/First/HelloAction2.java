package cn.leon.First;

import com.opensymphony.xwork2.Action;

/**
 * Created by leon on 2018/6/11.
 */
public class HelloAction2 implements Action {
    @Override
    public String execute() throws Exception {
        System.out.println("进入了HelloAction2");
        return SUCCESS;
    }

}
