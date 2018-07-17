package cn.leon.dao;

import cn.leon.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by leon on 2018/7/17.
 */
public interface ILoginDAO {
    //登陆
    public Users login(String name,String password);
    //修改密码
    public int updateUser(String password,int id);
    //查询所有会员
    public List<Users> findAll(@Param("uname")String name);
}
