import cn.happy.hibernate.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 *
 * 瞬时态和游离态的区别就是是否拥有OID！
 * OID怎么来的？只要曾经被session管理过的对象都有OID！
 *
 *  save():   把瞬时态转换成持久态
 *  update(): 把游离态转换成持久态
 *  saveOrUpdate():
 *         会根据对象是否有OID来判断执行save还是update
 *           如果有oid  执行update
 *           如果没有oid  执行save
 *  merge()： 产生的sql语句和saveOrUpdate有点类似，
 *            但是！！！！！
 *            01.merge不会改变对象的状态
 *            02.当我们的对象处于瞬时状态时，会将对象复制一份到session的缓存中，
 *              然后执行save方法，执行insert
 */
/**
 * Created by leon on 2018/5/28.
 */
public class TeacherTest02 {
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
    /*
    * 三种状态
    * 瞬时  new对象的时候 没哟OID
    * 持久   有OID作为主键标识
    * 游离  save  update saveOrupdate 曾经只要存在过oid的都是游离状态
    * */

    /**
     *如果表中没有数据  select insert
     */
    @Test
    public void test1(){
        Teacher teacher=new Teacher(); //瞬时状态
        teacher.setName("我是第六号好老师");//瞬时状态
        session.save(teacher);//s持久状态
    }

    /**
     *    如果表中有数据  select update
     */
    @Test
    public void test2(){
        Teacher teacher=session.get(Teacher.class,1);//持久化状态
        teacher.setName("我是第一号好老师");
        session.save(teacher);
        /**
         * 因为teacher已经是持久态  所以这里可以不需要save或者update
         */
    }

    @Test
    public void update2(){
        Teacher teacher=session.get(Teacher.class,1);//持久化状态
        teacher.setName("我是一号老师");
        /**
         * 因为teacher已经是持久态  所以这里可以不需要save或者update
         */
    }

    /**
     * 如果数据库没有数据
     * 1.select
     * 2.insert
     Hibernate: select max(tid) from teacher
     Hibernate: insert into teacher (name, tid) values (?, ?)
     */
    @Test
    public void test5(){
        Teacher teacher=new Teacher();//瞬时状态  还没有被hibernate管理
        teacher.setName("我是三号老师");//瞬时状态
        session.saveOrUpdate(teacher);//持久化状态
    }
    /**
     * 如果数据库有数据
     * 1.select
     * 2.update
     Hibernate: select teacher0_.tid as tid1_0_0_, teacher0_.name as name2_0_0_ from teacher teacher0_ where teacher0_.tid=?
     Hibernate: update teacher set name=? where tid=?
     */
    @Test
    public void test4(){
        Teacher teacher=session.get(Teacher.class,3);//持久化状态
        teacher.setName("我是三老师");
        session.saveOrUpdate(teacher);
    }
    /**
     * merge 如果数据库没有数据
     * 1.select
     * 2.insert
     Hibernate: select max(tid) from teacher
     Hibernate: insert into teacher (name, tid) values (?, ?)
     */
    @Test
    public void merge1(){
        Teacher teacher=new Teacher();
        teacher.setName("我是五号老师");
        session.merge(teacher);

    }
    /**
     * merge 如果数据库有数据
     * 1.select
     * 2.update
     Hibernate: select teacher0_.tid as tid1_0_0_, teacher0_.name as name2_0_0_ from teacher teacher0_ where teacher0_.tid=?
     Hibernate: update teacher set name=? where tid=?
     */
    @Test
    public void merge2(){
        Teacher teacher=session.get(Teacher.class,5);
        teacher.setName("我是五号号老师");
        session.merge(teacher);
    }
    /**
     *  merge  不改变对象的状态
     */
    @Test
    public void merge3(){
        Teacher teacher=new Teacher(7,"我是第七号好老师");//瞬时状态
        session.merge(teacher);//不会改变对象的状态
        teacher.setName("我是第七号超级好老师");//瞬时状态
        session.update(teacher);//会报错
    }







}
