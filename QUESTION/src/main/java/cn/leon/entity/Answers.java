package cn.leon.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by leon on 2018/7/10.
 */
public class Answers {
    private Integer id;
    private String ansContent;  //答案内容
    private Date ansDate;   //回答时间
    private Integer qid;  //问题id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnsContent() {
        return ansContent;
    }

    public void setAnsContent(String ansContent) {
        this.ansContent = ansContent;
    }

    public String getAnsDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(this.ansDate);
    }

    public void setAnsDate(Date ansDate) {
        this.ansDate = ansDate;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }
}
