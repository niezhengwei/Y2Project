package Dao;

import entity.User;

import java.util.List;

/**
 * Created by leon on 2018/3/13.
 */
public interface StudentDao{
    public List<User> findAll();
}
