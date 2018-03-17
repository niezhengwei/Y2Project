package Dao;

import entity.book;

import java.util.List;
import java.util.Map;

/**
 * Created by leon on 2018/1/29.
 */
public interface IBookDao {
    //查询全部
    public List<book> finallbooks();
    //添加数据
    public int addbook(book books);
    //删除数据
    public int deletebook(int bookid);
    //根据单个返回图书对象
    public book bookname(String name);
    //模糊查询
    public List<book> likeSelect(String bookName);
//多条件查询
    public List<book> selectMultMap(Map<String,Object> map);
//多条件索引查询
    public List<book> selectMultIndex(String bookname,Integer bookprice);
//智能标签if查询
    public List<book> selectIf(book bok);
    //foreach array
    public List<book> foreachArray(int[] ids);
    //foreach List
    public List<book> foreachArrayList(List<Integer> list);
    //foreach 自定义类型
    public List<book> foreachArrayBook(List<book> list);
}
