package cn.leon;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by leon on 2018/6/29.
 */
public class Demo {
    private Integer id;
    private String name;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
