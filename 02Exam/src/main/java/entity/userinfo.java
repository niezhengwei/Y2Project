package entity;

import java.util.Date;

/**
 * Created by leon on 2018/1/30.
 */
public class userinfo {
    private  int stuId;
    private String stuname;
    private int topicid;
    private String topicanswer;
    private Date createtime;
    private String classname;

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public int getTopicid() {
        return topicid;
    }

    public void setTopicid(int topicid) {
        this.topicid = topicid;
    }

    public String getTopicanswer() {
        return topicanswer;
    }

    public void setTopicanswer(String topicanswer) {
        this.topicanswer = topicanswer;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
