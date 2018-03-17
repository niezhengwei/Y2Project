import Dao.IBookDao;
import Dao.IdeptDao;
import entity.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import util.MyBatisUtil;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.ibatis.ognl.DynamicSubscript.all;

/**
 * Created by leon on 2018/2/22.
 */
public class Test20180222 {
    @Test
    public void test1(){
        String path="mybatis-config.xml";
        try{
            // System.out.println(111);
            InputStream is= Resources.getResourceAsStream(path);
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession =factory.openSession();

            IBookDao mapper = sqlSession.getMapper(IBookDao.class);
            book books = mapper.bookname("天蚕土豆");
            System.out.println(books.getBookName());
            sqlSession.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void test2(){
        String path="mybatis-config.xml";
        try{
            // System.out.println(111);
            InputStream is= Resources.getResourceAsStream(path);
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession =factory.openSession();

            IBookDao mapper = sqlSession.getMapper(IBookDao.class);
            List<book> books = mapper.likeSelect("大");
            for (book item : books){
                System.out.println(item.getBookName());
            }
            sqlSession.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    @Test
    public void test3(){

          SqlSession sqlSession= MyBatisUtil.getSession();
            IBookDao mapper = sqlSession.getMapper(IBookDao.class);
            book books = new book();
            books.setBookName("遮天");
            books.setBookAuther("辰东");
            books.setbookPrice(300);

            mapper.addbook(books);
            System.out.println(books.getBookId());
          sqlSession.commit();
            sqlSession.close();
        }
    @Test
    public void test4(){

        SqlSession sqlSession= MyBatisUtil.getSession();
        IBookDao mapper = sqlSession.getMapper(IBookDao.class);
        Map<String,Object> map=new HashMap<String,Object>();

        map.put("bookName","大");
        map.put("bookprice",100);
        List<book> books = mapper.selectMultMap(map);
        for(book item:books){
            System.out.println(item.getBookName());
        }

        sqlSession.close();
    }
    @Test
    public void test5(){

        SqlSession sqlSession= MyBatisUtil.getSession();
        IBookDao mapper = sqlSession.getMapper(IBookDao.class);

        List<book> list = mapper.selectMultIndex("大", 300);
        for(book item:list){
            System.out.println(item.getBookName());
        }
        sqlSession.close();
    }

    @Test
    public void test6(){

        SqlSession sqlSession= MyBatisUtil.getSession();
        IBookDao mapper = sqlSession.getMapper(IBookDao.class);

         book books=new book();
        books.setBookName("大");
         books.setbookPrice(100);

        List<book> list = mapper.selectIf(books);

        for(book item:list){
            System.out.println(item.getBookName());
        }
        sqlSession.close();
    }
    @Test
    public void test7(){

        SqlSession sqlSession= MyBatisUtil.getSession();
        IBookDao mapper = sqlSession.getMapper(IBookDao.class);
        int[] ids={1,3};
        List<book> books = mapper.foreachArray(ids);

        for(book item:books){
            System.out.println(item.getBookName());
        }
        sqlSession.close();
    }
    @Test
    public void test8(){

        SqlSession sqlSession= MyBatisUtil.getSession();
        IBookDao mapper = sqlSession.getMapper(IBookDao.class);
        List<Integer> lists=new ArrayList<Integer>();
        lists.add(1);
        lists.add(2);
        List<book> books = mapper.foreachArrayList(lists);
        for(book item:books){
            System.out.println(item.getBookName());
        }
        sqlSession.close();
    }

    @Test
    public void test9(){

        SqlSession sqlSession= MyBatisUtil.getSession();
        IBookDao mapper = sqlSession.getMapper(IBookDao.class);
        List<book> lists=new ArrayList<book>();
        book books=new book();
        books.setBookId(3);
        book books1=new book();
        books1.setBookId(2);
        lists.add(books);
        lists.add(books1);
        List<book> list = mapper.foreachArrayBook(lists);
        for(book item:list){
            System.out.println(item.getBookName());
        }
        sqlSession.close();
    }
    //一对多单条SQL
    @Test
    public void test10(){

        SqlSession sqlSession= MyBatisUtil.getSession();
        IdeptDao mapper = sqlSession.getMapper(IdeptDao.class);
        dept all = mapper.findAlldeptName(1);
        System.out.println(all.getDeptName());
        for (emp item:all.getEmps()) {
            System.out.println(item.getEmpName());
        }
        sqlSession.close();
    }
    //一对多多条Sql
    @Test
    public void test11(){

        SqlSession sqlSession= MyBatisUtil.getSession();
        IdeptDao mapper = sqlSession.getMapper(IdeptDao.class);
        dept all = mapper.findAllMoreDeptName(1);
        System.out.println(all.getDeptName());
        for (emp item:all.getEmps()) {
            System.out.println(item.getEmpName());
        }
        sqlSession.close();
    }

    //多对一单条sql
    @Test
    public void test12(){

        SqlSession sqlSession= MyBatisUtil.getSession();
        IdeptDao mapper = sqlSession.getMapper(IdeptDao.class);
        emp all = mapper.findAllemp(1);
        System.out.println(all.getEmpName());
        System.out.println(all.getDepts().getDeptName());
        sqlSession.close();
    }

    //多第一多条sql
    @Test
    public void test13(){

        SqlSession sqlSession= MyBatisUtil.getSession();
        IdeptDao mapper = sqlSession.getMapper(IdeptDao.class);
        emp all = mapper.findAllemps(1);
        System.out.println(all.getEmpName());
        System.out.println(all.getDepts().getDeptName());
        sqlSession.close();
    }
    //根据老师编号查询学生集合
    @Test
    public void test14(){

        SqlSession sqlSession= MyBatisUtil.getSession();
        IdeptDao mapper = sqlSession.getMapper(IdeptDao.class);
        Teacher all = mapper.findAllStudent(1);
        System.out.println(all.getTname());
        for (Student item:all.getStu()){
            System.out.println(item.getSname());
        }
        sqlSession.close();
    }
    //自关联
    @Test
    public void test15(){

        SqlSession sqlSession= MyBatisUtil.getSession();
        IdeptDao mapper = sqlSession.getMapper(IdeptDao.class);
        List<category> lists = mapper.findAllById(0);
        for (category item:lists){
            System.out.println(item);
        }
        sqlSession.close();
    }
    }
