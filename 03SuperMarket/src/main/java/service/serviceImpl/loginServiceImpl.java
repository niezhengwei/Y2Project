package service.serviceImpl;

import Dao.loginDao;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import service.loginService;
import util.MyBatisUtil;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by leon on 2018/2/25.
 */
public class loginServiceImpl implements loginService {
    loginDao mapper;
    public loginServiceImpl(){
        SqlSession session= MyBatisUtil.getSession();
        mapper=session.getMapper(loginDao.class);
    }
    public User loginservice(String userCode,String userPassword) throws SQLException {
        return mapper.login(userCode,userPassword);
    }

    public List<User> findAllservice() {
        return mapper.findAll();
    }

    public int updateService(String oldPwd, String newPwd,String name) {
        return mapper.update(oldPwd,newPwd,name);
    }
}
