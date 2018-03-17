package entity;

import java.io.Serializable;

/**
 * Created by leon on 2018/2/26.
 */
public class emp implements Serializable {
    private  Integer empNo;
    private String empName;
    private Integer deptNo;

    private dept depts;

    public dept getDepts() {
        return depts;
    }

    public void setDepts(dept depts) {
        this.depts = depts;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }
}
