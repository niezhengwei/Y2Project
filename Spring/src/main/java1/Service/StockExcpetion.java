package Service;

/**
 * Created by leon on 2018/3/15.
 */
public class StockExcpetion extends  ClassNotFoundException {

    public StockExcpetion() {
    }
    public StockExcpetion(String s) {
        super(s);
    }

}
