import Dao.DaoImpl.UserDaoImpl;
import Dao.UserDao;
import entity.login;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by leon on 2018/1/30.
 */
public class Test20180130 {
    @Test
    public void test1() throws SQLException {
        login los=new login();
        UserDao users=new UserDaoImpl();
        los.setUsername("1");
        los.setUpwd("1");
        login login = users.Login(los);
        if(login!=null){
            System.out.println(login.getUsername());
        }

    }

}
