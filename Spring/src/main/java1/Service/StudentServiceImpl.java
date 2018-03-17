package Service;

import Dao.StudentDao;
import entity.User;

import java.util.List;

/**
 * Created by leon on 2018/3/13.
 */
public class StudentServiceImpl implements StudentService {
    StudentDao dao;
    public StudentDao getDao() {
        return dao;
    }
    public void setDao(StudentDao dao) {
        this.dao = dao;
    }

    public List<User> findAll() {
        return dao.findAll();
    }
}
