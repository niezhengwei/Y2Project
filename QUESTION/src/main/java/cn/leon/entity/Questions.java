package cn.leon.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by leon on 2018/7/10.
 */
public class Questions {
    private Integer id;
    private String title;
    private String detailDesc;
    private Integer answerCount;
    private Date lastTime;

    public List<Answers> getLists() {
        return lists;
    }

    public void setLists(List<Answers> lists) {
        this.lists = lists;
    }

    private List<Answers> lists=new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }

    public Integer getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
    }

    public String getLastTime() {
        return  new SimpleDateFormat("yyyy-MM-dd").format(this.lastTime);
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
}
