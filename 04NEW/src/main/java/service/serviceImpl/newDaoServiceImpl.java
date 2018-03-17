package service.serviceImpl;

import Dao.newDao;
import entity.news;
import entity.page;
import entity.talk;
import org.apache.ibatis.session.SqlSession;
import service.newDaoService;
import util.MyBatisUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by leon on 2018/3/1.
 */
public class newDaoServiceImpl implements newDaoService {
    newDao mapper;
    public newDaoServiceImpl(){
        SqlSession session= MyBatisUtil.getSession();
        mapper=session.getMapper(newDao.class);
    }
    public page<news> findAlls(int pageIndex, int pageSize) {
        List<news> all = mapper.findAll((pageIndex-1)*pageSize, pageSize);
        page<news> pages=new page<news>();
        pages.setLists(all);
        pages.setPageIndex(pageIndex);
        pages.setPageSize(pageSize);
        pages.setTotalSize(getCounts());
        return pages ;
    }

    public int getCounts() {
        return mapper.getCount();
    }

    public List<talk> findAllList(int id) {
        return mapper.findAllList(id);
    }

    public int insert(String content, Date datetime, int newsid) {
        return mapper.insert(content,datetime,newsid);
    }

    public news findAllNews(int newsid) {
        return mapper.findNews(newsid);
    }

    public int update(int newid) {
        return mapper.update(newid);
    }

}
