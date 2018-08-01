import cn.happy.hibernate.Util.SessionFactoryUtil;
import cn.happy.hibernate.entity.Dept;
import cn.happy.hibernate.entity.Emp;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 2018/6/4.
 */
public class CriteriaTest {
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
    //查询全部信息
    @Test
    public void Test(){
        Criteria criteria = session.createCriteria(Dept.class);
        List<Dept> list=criteria.list();
        for(Dept item:list){
            System.out.println(item);
        }
    }
    //查询指定部门的信息
    @Test
    public void Test02(){
        Criteria criteria = session.createCriteria(Dept.class);
        criteria.add(Restrictions.eq("name","研发部"));
        Dept o = (Dept) criteria.uniqueResult();
        System.out.println(o);
    }
    //查询薪水大于10k的信息
    @Test
    public void Test03(){
        Criteria criteria = session.createCriteria(Emp.class);
        //条件
        criteria.add(Restrictions.gt("sal",10000d));
        List<Emp> list = criteria.list();
        for (Emp item:list){
            System.out.println(item);
        }
    }
    //查询薪水在5k-10k之间
    @Test
    public void Test04(){
        Criteria criteria = session.createCriteria(Emp.class);
        //条件
        criteria.add(Restrictions.between("sal",5000d,10000d));
        List<Emp> list = criteria.list();
        for (Emp item:list){
            System.out.println(item);
        }

    }
    //没有部门的员工信息
    @Test
    public void Test05(){
        Criteria criteria = session.createCriteria(Emp.class);
        criteria.add(Restrictions.isNull("dept"));
        List<Emp> list = criteria.list();
        for (Emp item:list){
            System.out.println(item);
        }
    }
    //没有员工的部门信息  集合使用IsEmpy  域属性使用IsNull
    @Test
    public void Test06(){
        Criteria criteria = session.createCriteria(Dept.class);
        criteria.add(Restrictions.isEmpty("empSet"));
        List<Dept> list = criteria.list();
        for (Dept item:list){
            System.out.println(item);
        }
    }
    //查询程序员是1或者财务员是1的信息  使用or查询
    @Test
    public  void Test07(){
        Criteria criteria = session.createCriteria(Emp.class);
        criteria.add(
                Restrictions.or(
                        Restrictions.eq("job","程序猿1"),
                        Restrictions.eq("job","财务猿1")
                ));
        List<Emp> list = criteria.list();
        for(Emp item:list){
            System.out.println(item);
        }
    }
    //查询程序员是1或者财务员是1的信息  使用in查询
    @Test
    public  void Test08(){
        Criteria criteria = session.createCriteria(Emp.class);
        List<String> jobs=new ArrayList<String>();
        jobs.add("程序猿1");
        jobs.add("财务猿1");
        criteria.add(Restrictions.in("job",jobs));
        List<Emp> list = criteria.list();
        for(Emp item:list){
            System.out.println(item);
        }
    }
    //查询程序员是1或者财务员是1的信息  使用disJunction查询
    @Test
    public  void Test09(){
        Criteria criteria = session.createCriteria(Emp.class);
        criteria.add(Restrictions.disjunction()
                .add(Restrictions.eq("job","财务猿1"))
                .add(Restrictions.eq("job","程序猿1")));
        List<Emp> list = criteria.list();
        for(Emp item:list){
            System.out.println(item);
        }
    }
    //模糊查询  查询员工姓名中包含A
    @Test
    public  void Test010(){
        Criteria criteria = session.createCriteria(Emp.class);
        criteria.add(Restrictions.like("name","a", MatchMode.END));
        List<Emp> list = criteria.list();
        for(Emp item:list){
            System.out.println(item);
        }
    }
    //聚合函数  最高  最低  平均  总 薪水
    @Test
    public void Test11(){
        Criteria criteria = session.createCriteria(Emp.class);
        criteria.setProjection(Projections.projectionList()
                .add(Projections.max("sal"))
                .add(Projections.min("sal"))
                .add(Projections.avg("sal"))
                .add(Projections.sum("sal")));
        List<Object[]> list = criteria.list();
        for (Object[] item:list){
            System.out.println("最高薪水："+item[0]);
            System.out.println("最低薪水："+item[1]);
            System.out.println("平均薪水："+item[2]);
            System.out.println("总薪水："+item[3]);
        }
    }
    //查询姓名中包含b的员工  并且按照薪水降序排列
    @Test
    public void Test12(){
       int count=((Long) session.createCriteria(Emp.class).add(Restrictions.ilike("name","b",MatchMode.ANYWHERE)).
                setProjection(Projections.count("name")).uniqueResult()).intValue();
       int pageSize=2;
       int pageIndex=1;
       //总页数
        int totalpage=(count%pageSize==0)?(count/pageSize):(count/pageSize+1);
        Criteria criteria = session.createCriteria(Emp.class).add(Restrictions.ilike("name", "b", MatchMode.ANYWHERE))
                .addOrder(Order.desc("sal"));
        List<Emp> list = criteria.setFirstResult((pageIndex - 1) * pageSize).setMaxResults(pageSize).list();
        for (Emp item:list){
            System.out.println(item);
        }
    }
    //验证二级缓存是否配置成功
    @Test
    public void Test13(){
        Dept dept = session.get(Dept.class, 1);
        session.clear();
        Dept dept2 = session.get(Dept.class, 1);
    }


}
