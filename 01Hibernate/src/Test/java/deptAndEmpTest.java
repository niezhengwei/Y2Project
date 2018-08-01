import cn.happy.hibernate.Util.SessionFactoryUtil;
import cn.happy.hibernate.entity.Emp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

/**
 * Created by leon on 2018/5/30.
 */
public class deptAndEmpTest {
    Transaction transaction=null;
    Session session=null;

    @Before
    public void before(){
        //读取核心配置文件
        Configuration cf=new Configuration().configure();
        //创建session会话
        SessionFactory factory=cf.buildSessionFactory();
        //打开会话
        session = SessionFactoryUtil.getCurrentSession();
        //事务  开启事务
        transaction=session.beginTransaction();
    }
    @After
    public void after(){
        //提交事务
        transaction.commit();
        //关闭会话
        session.close();
    }
    //普通内连接  返回一个Object[]
    @Test
    public void Test01(){
        String hql="from Emp e inner join e.dept";
        List<Object[]> list = session.createQuery(hql).list();
        for (Object[] item:list){
            System.out.println(item[0]);
            System.out.println(item[1]);
        }
    }
    //迫切内连接   返回一个Object对象
    @Test
    public void Test02(){
        String hql="from Emp e inner join fetch e.dept";
        List<Emp> list = session.createQuery(hql).list();
        for (Emp item:list){
            System.out.println(item);
        }
    }
    //左外连接
    @Test
    public void Test03(){
        String hql="from Emp e left join e.dept";
        List<Object[]> list = session.createQuery(hql).list();
        for (Object[] item:list){
            System.out.println(item[0]);
            System.out.println(item[1]);
        }
    }

    //迫切左外连接
    @Test
    public void Test04(){
        String hql="from Emp e left join fetch e.dept";
        List<Emp> list = session.createQuery(hql).list();
        for (Emp item:list){
            System.out.println(item);
        }
    }
    //hql查询
    @Test
    public void test05(){
        List<Emp> getAllEmps = session.getNamedQuery("getAllEmps").list();
        for(Emp item:getAllEmps){
            System.out.println(item);
        }
    }
    //SQL-query查询  sql-query返回的是Object[]数组
    @Test
    public void test06(){
        List<Object[]> getAllEmps = session.getNamedQuery("getAllEmpsSql").list();
        for(Object[] item:getAllEmps){
            System.out.println(item[0]);
            System.out.println(item[1]);
        }
    }

    //带参数的命名查询    根据id查询出指定的对象
    @Test
    public void test07(){
        List<Object[]> getAllEmps = session.getNamedQuery("getAllEmpsSqlId").setParameter("id",1).list();
        for(Object[] item:getAllEmps){
            System.out.println(item[0]);
            System.out.println(item[1]);
        }
    }
    //返回指定的对象
    @Test
    public void test08(){
        Query query = session.getNamedQuery("getAllEmpsSqlIdEmp").setParameter("id", 1);
        //将查询出来的结果转换成指定的对象
        query.setResultTransformer(Transformers.aliasToBean(Emp.class));
        //查询id为1的数据返回的是唯一的数据
        Emp o =(Emp) query.uniqueResult();
        System.out.println(o);

    }


}
