package cn.leon.service.Impl;

import cn.leon.dao.IQuestionDAO;
import cn.leon.entity.Answers;
import cn.leon.entity.Questions;
import cn.leon.service.IQuestionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by leon on 2018/7/10.
 */
@Service("questionservice")
public class IQuestionServiceImpl implements IQuestionService {

     @Resource(name = "IQuestionDAO")
    private IQuestionDAO questionDAO;

    @Override
    public List<Questions> findAll() {
        return questionDAO.findAll();
    }

    @Override
    @Transactional
    public int AddQuestion(Questions q) {
        //添加问题
        return questionDAO.AddQuestion(q);
    }

    @Override
    public Questions findAllId(int id) {
        return questionDAO.findAllId(id);
    }

    @Override
    @Transactional
    public int addAnswer(String ansContent, Date ansDate, Integer ids) {
        return questionDAO.addAnswer(ansContent,ansDate,ids);
    }
}
