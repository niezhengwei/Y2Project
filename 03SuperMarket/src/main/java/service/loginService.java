package service;

import entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by leon on 2018/2/25.
 */
public interface loginService {
    public User loginservice(String userCode,String userPassword) throws SQLException;
    public List<User> findAllservice();
    public int updateService(String oldPwd,String newPwd,String name);
}
