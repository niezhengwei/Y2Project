package Dao.DaoImpl;

import Dao.DaoBase;
import Dao.UserDao;
import entity.login;
import entity.result;
import entity.teacher;
import entity.userinfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 2018/1/30.
 */
public class UserDaoImpl extends DaoBase implements UserDao {

    public login Login(login info) throws SQLException {
        login lo=null;
        String sql="select * from user where username=? and upwd=?";
        ResultSet rs= exeQuery(sql, info.getUsername(), info.getUpwd());
        while(rs.next()){
            lo=new login();
            String name = rs.getString("username");
            String classname = rs.getString("classname");
            if(name!=null){
            lo.setUsername(name);
            lo.setClassname(classname);
        }
        String pwd = rs.getString("upwd");
        if(pwd!=null){
            lo.setUpwd(pwd);
        }
    }
        return lo;
    }

    public int input(teacher tea) {
        String sql="INSERT INTO answer(classname,topicid,answer)VALUES(?,?,?)";
        int insert = exeUpDate(sql, tea.getClassname(), tea.getTopicid(), tea.getAnswer());
        if(insert>0){
            return  insert;
        }
        return 0;
    }

    public int delete(String name) {
        String sql="delete from answer where classname=? ";
        int delete = exeUpDate(sql, name);
        if(delete>0){
            return delete;
        }
        return 0;
    }

    public int counts(String name) throws SQLException {
        String sql="SELECT COUNT(*) as scorecount FROM answer AS s,student AS t WHERE s.`topicid`=t.`topicid` AND s.`answer`=t.`topicanswer` AND stuname=?";
        ResultSet rs = exeQuery(sql, name);
        while(rs.next()){
            return rs.getInt("scorecount");
        }
        return 0;
    }

    public int inserts(result rss) {
        String sql="insert into result(stuname,stuscore,createtime,classname)values(?,?,?,?)";
        int i = exeUpDate(sql, rss.getStuname(), rss.getStuscore(), rss.getCreatetime(),rss.getClassname());
        return i;
    }

    public String result(String name) throws SQLException {
        String sql="SELECT stuname FROM result WHERE stuname=? ";
        ResultSet rs =exeQuery(sql, name);
        while(rs.next()){
           return rs.getString("stuname");
        }
      return  null;
    }

    public List<result> showAll(String classname) throws SQLException {
        String sql="select * from result where classname=?";
        ResultSet set = exeQuery(sql, classname);
        List<result> lists=new ArrayList<result>();
        while(set.next()){
            result rs=new result();
            rs.setResultId(set.getInt("resultId"));
            rs.setStuname(set.getString("stuname"));
            rs.setStuscore(set.getInt("stuscore"));
            rs.setCreatetime(set.getDate("createtime"));
            rs.setClassname(set.getString("classname"));
            lists.add(rs);
        }
        return lists;
    }

    public String showAlls(String name) throws SQLException {
        String sql="select stuname from student where stuname=?";
        ResultSet set = exeQuery(sql, name);
        while(set.next()){
            return set.getString("stuname");
        }
        return null;
    }

    public  int MAx(String classname) throws SQLException {
        String sql="SELECT MAX(stuscore) as a FROM result WHERE classname=?";
        ResultSet rs = exeQuery(sql, classname);
        while(rs.next()){
            return rs.getInt("a");
        }
        return 0;
    }

    public int Min(String classname) throws SQLException {
        String sql="SELECT MIN(stuscore) as b FROM result WHERE classname=? ";
        ResultSet set = exeQuery(sql, classname);
        while(set.next()){
            return set.getInt("b");
        }
        return 0;
    }

    public int avg(String classname) throws SQLException {
        String sql="SELECT AVG(stuscore) as g FROM result WHERE classname=? ";
        ResultSet set = exeQuery(sql, classname);
        while(set.next()){
            return set.getInt("g");
        }
        return 0;
    }

    public List<login> findAll() throws SQLException {
        String sql="select * from user";
        List<login> lists=new ArrayList<login>();
        ResultSet rs = exeQuery(sql);
        while(rs.next()){
            login lo=new login();
            lo.setUid(rs.getInt("uid"));
            lo.setUsername(rs.getString("username"));
            lo.setUpwd(rs.getString("upwd"));
            lo.setClassname(rs.getString("classname"));
        lists.add(lo);

        }
        return lists;
    }


}
