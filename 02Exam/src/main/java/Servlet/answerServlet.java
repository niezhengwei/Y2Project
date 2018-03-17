package Servlet;

import entity.login;
import entity.result;
import entity.userinfo;
import service.StuDaoService;
import service.UserService;
import service.serviceimpl.StuDaoServiceImpl;
import service.serviceimpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by leon on 2018/2/1.
 */
public class answerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // String name = request.getParameter("stuname");
        int rows = Integer.parseInt(request.getParameter("row"));
        int col = Integer.parseInt(request.getParameter("col"));
        login user = (login) request.getSession().getAttribute("user");
        try {
            StuDaoService stu = new StuDaoServiceImpl();
            result rsu = new result();
            UserService su = new UserServiceImpl();
            userinfo info = new userinfo();
            info.setStuname(user.getUsername());
            info.setClassname(user.getClassname());
            info.setCreatetime(new Date());
            String s = su.showAlls(user.getUsername());
            if (s==null) {
                for (int i = 0; i <= rows * col; i++) {
                    info.setTopicid(i);
                    String result = "";
                    String[] rs = request.getParameterValues("rchoice" + i);
                    if (rs != null) {
                        for (String str : rs) {
                            result = result + str;
                        }
                        info.setTopicanswer(result);

                        int insertservice = stu.insertservice(info);
                        //UserService inserts =(UserService)request.getSession().getAttribute("inserts");
                        if (insertservice > 0) {
                            System.out.println("操作成功！");
                        } else {
                            System.out.println("操作失败！");
                        }
                    }
                }
            }else{
                System.out.println("该学生已经提交过一次答案！");
            }
            try {
                int counts = su.counts(user.getUsername());
                rsu.setStuname(user.getUsername());
                rsu.setStuscore(counts);
                rsu.setCreatetime(new Date());
                rsu.setClassname(user.getClassname());
                String results = su.results(user.getUsername());
                if (results == null) {
                    su.inserts(rsu);
                    System.out.println(counts);
                } else {
                    System.out.println("已经提交过一次考试");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
