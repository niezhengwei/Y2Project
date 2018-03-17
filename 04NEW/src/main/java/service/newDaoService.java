package service;

import entity.news;
import entity.page;
import entity.talk;

import java.util.Date;
import java.util.List;

/**
 * Created by leon on 2018/3/1.
 */
public interface newDaoService {
    //展示信息
    public page<news> findAlls(int pageIndex, int pageSize);
    public int getCounts();

    public List<talk> findAllList(int id);

    public  int insert(String content,Date datetime,int newsid);

    public news findAllNews(int newsid);

    public int update(int newid);
}
