import Dao.IdeptDao;
import entity.dept;
import entity.emp;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MyBatisUtil;

/**
 * Created by leon on 2018/2/27.
 */
public class Test20180227 {

    /*
    * 延迟加载  只能用于多条SQL 单条SQL不可以
    * */
    @Test
    public void test10(){
        SqlSession sqlSession= MyBatisUtil.getSession();
        IdeptDao mapper = sqlSession.getMapper(IdeptDao.class);
        //直接加载  执行select语句  此时lazyLoadingEnabled是关闭的  false
        dept all = mapper.findAllMoreDeptName(1);
        //执行对关联对象的查询时  才会执行侵入式加载
        System.out.println(all.getDeptName());
        //当真正访问对关联对象的详情的时候  用到深度延迟加载
        for (emp item :all.getEmps()){
            System.out.println(item.getEmpName());
        }
        sqlSession.close();
    }

    //二级缓存
    @Test
    public void test11(){
        SqlSession sqlSession= MyBatisUtil.getSession();
        IdeptDao mapper = sqlSession.getMapper(IdeptDao.class);
        dept all = mapper.findAllMoreDeptName(1);
        System.out.println(all.getDeptName());
        sqlSession.close();

        System.out.println("====我是高贵的分割线====");
        SqlSession sqlSession2= MyBatisUtil.getSession();
        IdeptDao mapper2 = sqlSession2.getMapper(IdeptDao.class);
        dept all2 = mapper2.findAllMoreDeptName(1);
        System.out.println(all2.getDeptName());
        sqlSession.close();
    }
    //一级缓存的存在证明
    @Test
    public void test15(){
        SqlSession sqlSession= MyBatisUtil.getSession();
        IdeptDao mapper = sqlSession.getMapper(IdeptDao.class);
        dept all = mapper.findAllMoreDeptName(1);
        System.out.println(all.getDeptName());
       //增加  增删改方法会对一级缓存进行清空  在分割线下边在进行查询的时候就会重新发送SQL语句
        dept dep=new dept();
        dep.setDeptName("运营一部");
        mapper.add(dep);
        sqlSession.commit();
        System.out.println("====我是高贵的分割线====");
        dept all2 = mapper.findAllMoreDeptName(1);
        System.out.println(all2.getDeptName());
        sqlSession.close();
    }
}

