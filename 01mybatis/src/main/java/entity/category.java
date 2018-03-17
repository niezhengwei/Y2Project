package entity;

import java.util.Set;

/**
 * Created by leon on 2018/2/26.
 */
public class category {
    private Integer cid;
    private  String cname;
    private Integer pid;

    public Set<category> sets;

    @Override
    public String toString() {
        return "category{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", pid=" + pid +
                ", sets=" + sets +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Set<category> getSets() {
        return sets;
    }

    public void setSets(Set<category> sets) {
        this.sets = sets;
    }
}
