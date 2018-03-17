package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 2018/3/1.
 */
public class news {
    private  Integer newsid;
    private String newstitle;
    private String newscontent;
    private Integer clickcount;
    private List<talk> talks=new ArrayList<talk>();

    public List<talk> getTalks() {
        return talks;
    }

    public void setTalks(List<talk> talks) {
        this.talks = talks;
    }

    public Integer getNewsid() {
        return newsid;
    }

    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }

    public String getNewscontent() {
        return newscontent;
    }

    public void setNewscontent(String newscontent) {
        this.newscontent = newscontent;
    }

    public Integer getClickcount() {
        return clickcount;
    }

    public void setClickcount(Integer clickcount) {
        this.clickcount = clickcount;
    }
}
