package Dao;

import entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by leon on 2018/2/25.
 */
public interface loginDao {
    //登陆
    public User login(String userCode,String userPassword) throws SQLException;
    //用户列表
    public List<User> findAll();
    //修改密码
    public int update(String oldpwd,String newsPwd,String  name);

}
