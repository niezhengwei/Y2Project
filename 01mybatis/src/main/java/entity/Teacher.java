package entity;

import Dao.IdeptDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 2018/2/26.
 */
public class Teacher {
    private Integer tid;
    private String tname;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public List<Student> getStu() {
        return stu;
    }

    public void setStu(List<Student> stu) {
        this.stu = stu;
    }

    private List<Student> stu=new ArrayList<Student>();
}
