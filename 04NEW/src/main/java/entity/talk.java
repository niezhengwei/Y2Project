package entity;

import java.util.Date;

/**
 * Created by leon on 2018/3/1.
 */
public class talk {
    private Integer tid;
    private String content;
    private String talktime;


    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTalktime() {
        return talktime;
    }

    public void setTalktime(String talktime) {
        this.talktime = talktime;
    }
}
