package Service;

import Dao.IBookDao;
import entity.book;

/**
 * Created by leon on 2018/3/17.
 */
public class IBookServiceImpl implements IBookDaoService {
    IBookDao dao;

    public IBookDao getDao() {
        return dao;
    }

    public void setDao(IBookDao dao) {
        this.dao = dao;
    }

    public int addBook(book book) {
        return dao.addBook(book);
    }
}
