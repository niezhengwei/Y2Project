package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by leon on 2018/2/24.
 */
public class MyBatisUtil {


    static String path="mybatis-config.xml";
     static InputStream is;
    static SqlSessionFactory factory;
    static {
        try {
            is= Resources.getResourceAsStream(path);
            factory=new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSession(){
        return factory.openSession(true);
    }
}
