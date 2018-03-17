package Service;

import Dao.IAccountDao;
import Dao.IStockDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by leon on 2018/3/15.
 */
public class IAccountServiceImpl implements  IAccountService {
    IAccountDao accountDao;
    IStockDao stockDao;
    public IAccountDao getAccountDao() {
        return accountDao;
    }
    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }
    public IStockDao getStockDao() {
        return stockDao;
    }
    public void setStockDao(IStockDao stockDao) {
        this.stockDao = stockDao;
    }
    //@Transactional
    public boolean updateService(int aid, int abablance, int sid, int count) throws StockExcpetion {
        boolean flag=true;
          if(1==1){
              throw  new StockExcpetion("股票购买失败！");
          }
        boolean b = accountDao.updateAccount(aid,abablance,flag);
        boolean b1 = stockDao.updateStock(sid,count,flag);
        if (b&&b1){
            return true;
        }else{
            return  false;
        }
    }
}
