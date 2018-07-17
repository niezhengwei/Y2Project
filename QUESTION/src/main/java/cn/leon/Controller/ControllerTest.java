package cn.leon.Controller;

import cn.leon.entity.Answers;
import cn.leon.entity.Questions;
import cn.leon.service.IQuestionService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by leon on 2018/7/10.
 */
@Controller
public class ControllerTest {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @Resource(name = "questionservice")
    private IQuestionService questionService;

    @RequestMapping("/main")
    public String  domain(HttpSession session){
        List<Questions> all = questionService.findAll();
        session.setAttribute("questionList",all);
        return "forward:/indexs";
    }

    @RequestMapping("/indexs")
    public String doFirst(){
        return  "index";
    }

    @RequestMapping("/questionJSp")
    public String doFirsts(){
        return "question";
    }



    //添加问题
    @RequestMapping("/addquestion")
    public String add(String title,String detailDesc){
        Questions q=new Questions();
        q.setTitle(title);
        q.setDetailDesc(detailDesc);
        q.setLastTime(new Date());
        q.setAnswerCount(0);
        int i = questionService.AddQuestion(q);
        if(i>0){
            return "forward:/main";
        }
        return null;
    }

    @RequestMapping("/checkAnswer")
    public String doSecond(HttpSession session,Integer qid){
        Questions answers = questionService.findAllId(qid);
        session.setAttribute("answers",answers);
        return "forward:/findAllAnswer";

    }
    @RequestMapping("/findAllAnswer")
    public String doAnswer(Integer id,HttpSession session){
        return "answer";
    }
    //提交答案
    @RequestMapping("/addAnswer")
    public String addAnswer(String ansContent,Integer ids){
        questionService.addAnswer(ansContent,new Date(),ids);
        return "forward:/main";
    }

}
