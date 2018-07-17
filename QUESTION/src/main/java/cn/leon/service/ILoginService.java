package cn.leon.service;

import cn.leon.entity.Users;
import com.github.pagehelper.PageInfo;

/**
 * Created by leon on 2018/7/17.
 */
public interface ILoginService {
    //登陆
    public Users login(String name, String password);
    //修改密码
    public int updateUser(String password,int id);
    //查询
    PageInfo<Users> findAllUser(String name, int pageNum, int pageSize);
}
