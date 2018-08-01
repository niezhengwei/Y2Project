package cn.leon.service.Impl;

import cn.leon.dao.IUserDAo;
import cn.leon.entity.Users;
import cn.leon.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by leon on 2018/6/29.
 */

@Service("userservice")
public class IUserServiceImpl implements IUserService {

    @Resource(name = "IUserDAo")
    private IUserDAo userDAo;
    @Override
    @Transactional
    public void save(Users users) {
        userDAo.save(users);

    }
}
