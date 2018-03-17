package Subject;

/**
 * Created by leon on 2018/3/6.
 */
public class ProxySubject implements abstarct{

    private Zsubject zsubject=new Zsubject();

    public Zsubject getZsubject() {
        return zsubject;
    }

    public void setZsubject(Zsubject zsubject) {
        this.zsubject = zsubject;
    }

    public void request() {

        System.out.println("Before==之前");
        zsubject.request();
        System.out.println("After==之后");

    }
}
