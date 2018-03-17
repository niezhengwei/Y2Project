package Dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by leon on 2018/3/15.
 */
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {
    public boolean updateAccount(int aid, int abalance, boolean isBuy) {
        boolean flag=false;
        String sql=null;
        int count;
        if (isBuy){
            sql="update account set abalance=abalance-? where aid=?";
            count=  this.getJdbcTemplate().update(sql,abalance,aid);
        }else{
            sql="update account set abalance=abalance+? where aid=?";
            count= this.getJdbcTemplate().update(sql,abalance,aid);
        }
        if (count>0){
            flag=true;
        }
        return false;
    }
}
