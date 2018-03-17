package Dao;

import entity.Teacher;
import entity.category;
import entity.dept;
import entity.emp;

import java.util.List;

/**
 * Created by leon on 2018/2/26.
 */
public interface IdeptDao {
    //一对多单条sql
public dept findAlldeptName(int  deptNo);
    //一对多条sql
    public dept findAllMoreDeptName(int deptNo);
    //增加的方法
    public int add(dept no);
    //多对一单条sql
    public emp findAllemp(int empNo);
    //多对一多条sql
    public emp findAllemps(int empNo);
    //根据老师编号查询所属学生集合
    public Teacher findAllStudent(int tid);
    //自关联
    public List<category> findAllById(int pid);
}
