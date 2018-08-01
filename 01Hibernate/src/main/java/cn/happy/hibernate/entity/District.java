package cn.happy.hibernate.entity;
/**
 * Created by leon on 2018/5/30.
 */
import java.util.ArrayList;
import java.util.List;

/**
 * 区县
 */
public class District {
    private Integer id;
    private String name;
    private List<Street> streetList=new ArrayList<Street>();

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

    public List<Street> getStreetList() {
        return streetList;
    }

    public void setStreetList(List<Street> streetList) {
        this.streetList = streetList;
    }

    public District(Integer id, String name, List<Street> streetList) {
        this.id = id;
        this.name = name;
        this.streetList = streetList;
    }

    public District(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public District(){

    }

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", streetList=" + streetList.size() +
                '}';
    }
}
