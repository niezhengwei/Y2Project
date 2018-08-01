package cn.happy.hibernate.entity;

/**
 * Created by leon on 2018/5/30.
 */

/**
 * 街道实体类
 */
public class Street {
    private Integer id;
    private String name;
    private District district;

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

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

    public Street(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Street(){

    }

    @Override
    public String toString() {
        return "Street{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", district=" + district +
                '}';
    }
}
