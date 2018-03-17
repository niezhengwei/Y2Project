package Dao;

import entity.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by leon on 2018/3/13.
 */
public class StudentDaoImpl extends JdbcDaoSupport implements StudentDao {
    public List<User> findAll() {
        String sql="SELECT * FROM `user` ";
        List<User> query = this.getJdbcTemplate().query(sql, new RowMapper<User>() {
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPwd(rs.getString("upwd"));
                return user;
            }
        });
        return query;
    }
}
