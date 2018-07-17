package cn.leon.service.Impl;

import cn.leon.dao.ILoginDAO;
import cn.leon.entity.Users;
import cn.leon.service.ILoginService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by leon on 2018/7/17.
 */
@Service("loginservice")
public class ILoginServiceImpl implements ILoginService {

    @Resource(name = "ILoginDAO")
    private ILoginDAO loginDAO;
    @Override
    public Users login(String name, String password) {
        return loginDAO.login(name,password);
    }

    @Transactional
    @Override
    public int updateUser(String password, int id) {
        return loginDAO.updateUser(password,id);
    }

    @Override
    public PageInfo<Users> findAllUser(String name, int pageNum, int pageSize) {
        loginDAO.findAll(name);
        Page<Users> page = PageHelper.startPage(pageNum, pageSize);
        return page.toPageInfo();
    }
}
