package service.serviceimpl;

import Dao.DaoImpl.UserDaoImpl;
import Dao.UserDao;
import entity.login;
import entity.result;
import entity.teacher;
import service.UserService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by leon on 2018/1/30.
 */
public class UserServiceImpl implements UserService {
    UserDao users=new UserDaoImpl();
    public login Users(login lo) throws SQLException {
        return users.Login(lo);
    }

    public int insertservice(teacher tea) {
        return users.input(tea);
    }

    public int deleteservice(String name) {
        return users.delete(name);
    }

    public int counts(String name) throws SQLException {
        return users.counts(name);
    }

    public int inserts(result rst) {
        return users.inserts(rst);
    }

    public String results(String name) throws SQLException {
        return users.result(name);
    }

    public List<result> showAll(String name) throws SQLException {
        return users.showAll(name);
    }

    public String showAlls(String name) throws SQLException {
        return users.showAlls(name);
    }

    public int Max(String classname) throws SQLException {
        return users.MAx(classname);
    }

    public int Min(String classname) throws SQLException {
        return users.Min(classname);
    }

    public int avg(String classname) throws SQLException {
        return users.avg(classname);
    }

    public List<login> findAll() throws SQLException {
        return users.findAll();
    }
}
