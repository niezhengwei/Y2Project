package Servlet;

import entity.teacher;
import service.UserService;
import service.serviceimpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by leon on 2018/2/1.
 */
public class ImportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        teacher tea=new teacher();
        UserService users=new UserServiceImpl();
        String answer = request.getParameter("answer").trim();
        String classname = request.getParameter("classname").trim();
        //System.out.println(classname);
        tea.setClassname(classname);
        int deleteservice = users.deleteservice(classname);
        //System.out.println(deleteservice);
        if(answer!=null&&classname!=null){
            String[] split = answer.split(",");
            int i=0;
            for (String item: split) {
                i++;
                tea.setTopicid(i);
                tea.setAnswer(item.trim());
                int insert = users.insertservice(tea);
                request.getSession().setAttribute("inserts",insert);
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
