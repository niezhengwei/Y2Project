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
 * Created by leon on 2018/5/28.
 */
public class TeacherTest03 {
    Transaction transaction=null;
    Session session=null;

    @Before
    public void before(){
        //读取核心配置文件
        Configuration cf=new Configuration().configure();
        //创建session会话
        SessionFactory factory=cf.buildSessionFactory();
        //打开会话
        session = factory.openSession();
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

    //参数绑定  下标
    @Test
    public void test1(){
        String hql="from Teacher where tid=?";
        Query query = session.createQuery(hql);
        query.setParameter(0,1);
        Teacher teacher = (Teacher)query.uniqueResult();
        System.out.println(teacher);
    }
    //参数绑定
    @Test
    public void test2(){
        String hql="from Teacher where tid=:teid";
        Query query = session.createQuery(hql);
        query.setParameter("teid",1);
        Teacher teacher = (Teacher)query.uniqueResult();
        System.out.println(teacher);
    }
    //动态参数绑定
    @Test
    public void test3(){
        StringBuffer stu=new StringBuffer("from cn.happy.hibernate.entity.Teacher where 1=1");
        Teacher teacher=new Teacher();
        teacher.setAddress("上海");
        teacher.setSal(100.0);
        if(teacher.getSal()>0){
            stu.append(" and sal>:sals");
        }
        if(teacher.getAddress()!=null){
            stu.append(" and address like :addresses");
        }
        Query query = session.createQuery(stu.toString());
        query.setParameter("sals",teacher.getSal());
        query.setParameter("addresses",teacher.getAddress());
        List<Teacher> list = query.list();
        for (Teacher item: list){
            System.out.println(item);
        }
    }
    //投影查询
    @Test
    public void test4(){
        String hql="select name from Teacher";
        Query query = session.createQuery(hql);
        List<Object> list = query.list();
        for (Object item:list){
            System.out.println(item);
        }
    }
    //投影查询
    @Test
    public void test5(){
        String hql="select name,sal from Teacher";
       List<Object[]> list = session.createQuery(hql).list();
        for (Object[] item:list){
            System.out.println(item[0]);
            System.out.println(item[1]);
        }
    }
    @Test
    public void test6(){
        String hql="select new Teacher(name,sal) from Teacher";
        Query query = session.createQuery(hql);
        List<Teacher> list = query.list();
        for (Teacher item:list){
            System.out.println(item);
        }
    }
}
