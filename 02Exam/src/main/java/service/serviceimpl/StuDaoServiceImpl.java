package service.serviceimpl;

import Dao.DaoImpl.StuDaoImpl;
import Dao.StuDao;
import entity.userinfo;
import service.StuDaoService;

/**
 * Created by leon on 2018/2/1.
 */
public class StuDaoServiceImpl implements StuDaoService {
        StuDao stu=new StuDaoImpl();
    public int insertservice(userinfo infos) {
        return stu.insert(infos);
    }
}
