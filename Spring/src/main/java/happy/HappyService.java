package happy;

/**
 * Created by leon on 2018/3/3.
 */
public class HappyService {

/*    public HappyService(){
        System.out.println("第一个Spring程序！");
    }*/

    public String info;

    public HappyService(String info, Integer age) {
        this.info = info;
        this.age = age;
    }

    public Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void work(){
        System.out.println("work"+info);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
