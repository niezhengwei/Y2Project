package Dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by leon on 2018/3/15.
 */
public class IStockDaoImpl extends JdbcDaoSupport implements IStockDao {
    public boolean updateStock(int sid, int scount, boolean isBuy) {
        boolean flag=false;
        String sql=null;
        int count;
        if (isBuy){
            sql="update stock set scount=scount+? where sid=?";
            count= this.getJdbcTemplate().update(sql,scount,sid);
        }else{
            sql="update stock set scount=scount+? where sid=?";
            count= this.getJdbcTemplate().update(sql,scount,sid);
        }
        if (count>0){
            flag=true;
        }
        return false;

    }
}
