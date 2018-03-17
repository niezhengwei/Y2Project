package Dao;

/**
 * Created by leon on 2018/3/15.
 */
public interface IAccountDao {
    public boolean updateAccount(int aid,int abalance,boolean isBuy);
}
