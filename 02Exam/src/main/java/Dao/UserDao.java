package Dao;

import entity.login;
import entity.result;
import entity.teacher;
import entity.userinfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by leon on 2018/1/30.
 */
public interface UserDao {
    //登陆的方法
    public login Login(login info) throws SQLException;

    //老师录入答案的方法
    public int input (teacher tea);

    public int delete(String name);

    //学生在提交答案的时候就结算考试成绩,判断老师录入的答案和学生提交的答案是否匹配

    public int counts(String name) throws SQLException;

    //插入成绩表
    public int inserts(result rss);

    public String result(String name) throws SQLException;

    //页面上展示成绩
    public List<result> showAll(String classname) throws SQLException;

    //判断数据库是否存在相同的学生答案
    public String showAlls(String name) throws SQLException;

    //查询最高分
    public int MAx(String classname) throws SQLException;

    //查询最低分
    public  int Min(String classname) throws SQLException;

    //查询平均分
    public int avg(String classname) throws SQLException;

    public List<login> findAll() throws SQLException;

}
