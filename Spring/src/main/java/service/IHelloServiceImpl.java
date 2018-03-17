package service;

import Dao.IHelloDao;

/**
 * Created by leon on 2018/3/5.
 */
public class IHelloServiceImpl implements IHelloService {
    IHelloDao dao;

    public IHelloDao getDao() {
        return dao;
    }

    public void setDao(IHelloDao dao) {
        this.dao = dao;
    }

    public void some() {
        dao.getSomething();
    }
}
