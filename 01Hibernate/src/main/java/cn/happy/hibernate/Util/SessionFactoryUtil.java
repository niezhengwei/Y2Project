package cn.happy.hibernate.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by leon on 2018/5/30.
 */
public class SessionFactoryUtil {
    private static Configuration configuration;//加载核心文件所需要的类
    private static SessionFactory factory;//创建工厂

    static {
        configuration=new Configuration().configure();
        factory=configuration.buildSessionFactory();
    }
    public static Session getCurrentSession(){
        return factory.getCurrentSession();
    }
}
