package Dao;

/**
 * Created by leon on 2018/3/15.
 */
public interface IStockDao {
    public boolean updateStock(int sid,int scount,boolean isBuy);
}
