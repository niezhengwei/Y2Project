package service;

import entity.login;
import entity.result;
import entity.teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 * Created by leon on 2018/1/30.
 */
public interface UserService {
    public login Users(login lo) throws SQLException;

    public int insertservice(teacher tea);

    public int deleteservice(String name);

    public int counts(String name) throws SQLException;

    public int inserts(result rst);

    public String results(String name) throws SQLException;

    public List<result> showAll(String name) throws SQLException;

    public String showAlls(String name) throws SQLException;

    public int Max(String classname) throws SQLException;

    public int Min(String classname) throws SQLException;

    public int avg(String classname) throws SQLException;

    public List<login> findAll() throws SQLException;
}
