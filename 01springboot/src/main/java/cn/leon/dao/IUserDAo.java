package cn.leon.dao;

import cn.leon.entity.Users;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by leon on 2018/6/29.
 */
public interface IUserDAo extends CrudRepository<Users,Integer> {
}
