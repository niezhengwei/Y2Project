package cn.leon.entity;

/**
 * Created by Happy on 2017-11-29.
 */
//文章实体
public class Article {
    private Integer id;//编号
    private String title; //标题
    private String content; //内容

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
