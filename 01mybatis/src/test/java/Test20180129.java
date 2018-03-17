import entity.book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

/**
 * Created by leon on 2018/1/29.
 */
public class Test20180129 {
    @Test
    public void test1(){
        String path="mybatis-config.xml";
        try{
           // System.out.println(111);
            InputStream is= Resources.getResourceAsStream(path);
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession =factory.openSession();
            List<book> list = sqlSession.selectList("finallbooks");
            for (book item:list) {
                System.out.print(item.getBookName()+"\t"+item.getBookAuther()+"\n");
            }
            sqlSession.close();
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

   /* @Test
    public void test2(){
        String path="mybatis-config.xml";

            InputStream is= Resources.getResourceAsStream(path);
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession =factory.openSession();
            List<book> list = sqlSession.selectList("addbook");
           book bok=new book();
           bok.setBookName("遮天");
           bok.setBookAuther("辰东");
           bok.setbookPrice(50);
            int counts = sqlSession.insert("addbook", bok);
            sqlSession.commit();;
           if(counts>0){
               System.out.println("添加成功！");
           }else{
               System.out.println("添加失败！");
           }
        sqlSession.close();;
        }catch(Exception e){

        }

    }*/
    /*@Test
    public void test3(){
        String path="mybatis-config.xml";
        try{
            InputStream is= Resources.getResourceAsStream(path);
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession =factory.openSession();
            int delete = sqlSession.delete("deletebook", 1);
            sqlSession.commit();
            if(delete>0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
            sqlSession.close();;
        }catch(Exception e){

        }

    }*/
}
