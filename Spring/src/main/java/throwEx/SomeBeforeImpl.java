package throwEx;

/**
 * Created by leon on 2018/3/8.
 */
public class SomeBeforeImpl implements SomeBefore {
    public void sayhi() {
        int reslut=5/0;
        System.out.println("我是李白");
    }
}
