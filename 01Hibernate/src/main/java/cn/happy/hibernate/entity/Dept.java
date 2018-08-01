package cn.happy.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by leon on 2018/6/4.
 */
public class Dept {
    private Integer deptId;
    private String name;
    private String location;
    private Set<Emp> empSet=new HashSet<Emp>();

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Emp> getEmpSet() {
        return empSet;
    }

    public void setEmpSet(Set<Emp> empSet) {
        this.empSet = empSet;
    }
}
