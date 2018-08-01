import cn.happy.hibernate.Util.SessionFactoryUtil;
import cn.happy.hibernate.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by leon on 2018/5/30.
 */
public class Test04 {
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

    /**
     * 分页
     */
    @Test
    public void Test01(){
        //查询总记录数
        String hql="select count(1) from Teacher";
       int counts=((Long) session.createQuery(hql).uniqueResult()).intValue();
       //每一页展示几条数据
       int pagesize=3;
       //总页数
       int totalpage=(counts%pagesize==0)?(counts/pagesize):(counts/pagesize+1);
       //当前展示的第几页的数据
       int pageIndex=2;
       //查询全部
       hql="from Teacher";
        Query query = session.createQuery(hql);
        //设置从哪一条数据开始查询
        query.setFirstResult((pageIndex-1)*pagesize);
        //设置每一页展示的数据
        query.setMaxResults(pagesize);
        List<Teacher> list = query.list();
        for (Teacher item:list){
            System.out.println(item);
        }
    }
}
