package DamoAspectXml;

/**
 * Created by leon on 2018/3/8.
 */
public class SomeBeforeImpl implements SomeBefore {
    public void sayhi() {
        System.out.println("sayhi");
    }

    public void doSome() {
        System.out.println("doSome");
    }

    public void doGet() {
        System.out.println("doGet");
    }

    public void Ends(){
        System.out.println("End");
    };
}
