import cn.happy.hibernate.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;


/**
 * Created by leon on 2018/5/25.
 */
public class TeacherTest01 {
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

    //新增
    @Test
    public void test01(){
        //声明Teacher对象  要添加的数据
        Teacher teacher=new Teacher();
        teacher.setName("张老师");
        //保存
        session.save(teacher);
    }


    //删除
    @Test
    public void test02(){
        //声明Teacher对象  要添加的数据
        Teacher teacher=new Teacher();
        teacher.setId(2);
        //保存
        session.delete(teacher);
    }

    //修改
    @Test
    public void test03(){
        //声明Teacher对象  要添加的数据
        Teacher teacher=new Teacher();
        teacher.setId(1);
        teacher.setName("李老师");
        //保存
        session.update(teacher);
    }

    /**
     * 查询数据信息  get方法
     */
    @Test
    public void test04(){

        System.out.println("--------------------");
        Teacher teacher = session.get(Teacher.class, 3);
        System.out.println("--------------------");
        System.out.println(teacher.getName());
    }
    /**
     * 查询数据信息  load方法
     */
    @Test
    public void test05(){
        /*
        * load方法不会立即产生SQL语  并且存入缓存中  再次查询的时候 会先从一级缓存中找
        * 一级没有 再找二级缓存 二级缓存也没有数据  就访问数据库 如果数据库没有找到数据
        * 返回ObjectNotFoundException
        * */
        System.out.println("--------------------");
        Teacher teacher = session.load(Teacher.class, 3);
        System.out.println("---------------------");
        System.out.println(teacher.getName());
    }
    //evict方法 清除缓存中的指定数据
    @Test
    public void Test06(){
        Teacher teacher1 = session.get(Teacher.class, 1);
        Teacher teacher = session.get(Teacher.class, 3);
        //删除teacher1的缓存
        session.evict(teacher1);
        System.out.println("---------------------");
       teacher1 = session.get(Teacher.class, 1);
    }
    //clear方法  清空session中所有对象
    @Test
    public void Test07(){
        Teacher teacher1 = session.get(Teacher.class, 1);
        Teacher teacher = session.get(Teacher.class, 3);
        //清空所有
        session.clear();
        System.out.println("---------------------");
        teacher1 = session.get(Teacher.class, 1);
         teacher = session.get(Teacher.class, 3);
    }
    //list
    @Test
    public void Test08(){
        String hql="from Teacher";
        Query query = session.createQuery(hql);
        List<Teacher> list = query.list();
        for (Teacher item:list){
            System.out.println(item.getName());
        }
    }
    //iterator
    @Test
    public void Test09(){
        String hql="from Teacher";
        Query query = session.createQuery(hql);
        Iterator<Teacher> iterate = query.iterate();
        while(iterate.hasNext()){
            Teacher teacher = iterate.next();
            System.out.println(teacher.getName());
        }
    }

}
