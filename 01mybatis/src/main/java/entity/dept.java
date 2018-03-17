package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 2018/2/26.
 */
public class dept implements Serializable {
    private Integer deptNo;
    private String deptName;

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<emp> getEmps() {
        return emps;
    }

    public void setEmps(List<emp> emps) {
        this.emps = emps;
    }

    private List<emp> emps=new ArrayList<emp>();
}
