package Dao;

import entity.news;
import entity.page;
import entity.talk;

import java.util.Date;
import java.util.List;

/**
 * Created by leon on 2018/3/1.
 */
public interface newDao {
    //展示信息
    public List<news> findAll(int pageIndex, int pageSize);
    public int getCount();
    //显示评论内容
    public List<talk> findAllList(int id);
    //提交评论
    public int insert(String content,Date datetime,int newsid);
    //根据newsid获取news对象
    public news findNews(int newid);

    public int update(int newid);


}
