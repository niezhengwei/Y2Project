import cn.happy.hibernate.Util.SessionFactoryUtil;
import cn.happy.hibernate.entity.District;
import cn.happy.hibernate.entity.Street;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 2018/5/30.
 */
public class DistrictAndStreetTest {
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
    @Test
    public void Test01(){
        //添加数据
        District district=new District(1,"朝阳区");
        District district1=new District(2,"东城区");
        District district2=new District(3,"海淀区");
        session.save(district);
        session.save(district1);
        session.save(district2);
    }
    //一对多
    @Test
    public  void Test02(){
        Street street=new Street(1,"朝阳区1街道");
        Street street1=new Street(2,"朝阳区2街道");
        Street street2=new Street(3,"朝阳区3街道");
        List<Street> list=new ArrayList<Street>();
        list.add(street);
        list.add(street1);
        list.add(street2);
        District district = session.get(District.class, 1);
        district.setStreetList(list);
        session.save(district);
    }

    /*
            cascade: 只能设置在 一的一方
          1.none默认值：当我们操作对象时，忽略其关联属性
          2.save-update：在调用save,saveOrUpdate和update方法的时候，会级联的修改或保存当前对象
               以及所关联的对象！
         3.delete: 在调用delete的时候会级联的删除关联对象
          4.all： 包含了save-update和delete
     */

    /**
     * inverse默认为false!  不反转！ 我来维护！
        必须在一的一方  设置 inverse="true" 放弃维护的权力！
     */
    @Test
    public  void Test03(){
        Street street = session.get(Street.class, 1);
        System.out.println(street);
    }

    /**
     * 多对一
     */
    @Test
    public void Test04(){
        District district = session.get(District.class, 1);
        List<Street> streetList = district.getStreetList();
        for (Street item:streetList){
            System.out.println(item);
        }

    }


}
