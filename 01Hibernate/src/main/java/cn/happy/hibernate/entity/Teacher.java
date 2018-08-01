package cn.happy.hibernate.entity;

/**
 * Created by leon on 2018/5/25.
 */
public class Teacher
{
    private Integer id;
    private String  name;
    private String address;
    private Double sal;



    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", sal=" + sal +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
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

    public Teacher(int id,String name) {
        this.id=id;
        this.name = name;
    }
    public Teacher(){

    }
    public Teacher(String name,Double sal){
        this.name=name;
        this.sal=sal;
    }
}
