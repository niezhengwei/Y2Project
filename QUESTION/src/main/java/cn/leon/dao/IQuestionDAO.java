package cn.leon.dao;

        import cn.leon.entity.Answers;
        import cn.leon.entity.Questions;

        import java.util.Date;
        import java.util.List;

/**
 * Created by leon on 2018/7/10.
 */
public interface IQuestionDAO {
    public List<Questions> findAll();
    //添加问题
    public int AddQuestion(Questions q);
    //点击问题查看详细内容
    public Questions findAllId(int id);
    //添加答案
    public int addAnswer(String ansContent, Date ansDate, Integer ids);
}
