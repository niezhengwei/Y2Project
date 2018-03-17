package entity;

import java.util.Date;

/**
 * Created by leon on 2018/2/3.
 */
public class result {
    private int resultId;
    private String stuname;

    public int getStuscore() {
        return stuscore;
    }

    public void setStuscore(int stuscore) {
        this.stuscore = stuscore;
    }

    private int stuscore;
    private Date createtime;
    private String classname;

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }
    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

   /* public double getStuscore() {
        return stuscore;
    }

    public void setStuscore(double stuscore) {
        this.stuscore = stuscore;
    }
*/
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
