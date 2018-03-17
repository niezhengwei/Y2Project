package servlet;

import entity.news;
import entity.talk;
import service.newDaoService;
import service.serviceImpl.newDaoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by leon on 2018/3/1.
 */
public class newListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        newDaoService service=new newDaoServiceImpl();
        String action = request.getParameter("action");
        String id = request.getParameter("id");
        //获取文本域中的值
        String tname = request.getParameter("tname");
        if(action.equals("click")){
            news allNews = service.findAllNews(Integer.parseInt(id));
            int update = service.update(Integer.parseInt(id));
            request.setAttribute("all",allNews);
            request.getRequestDispatcher("/newlist.jsp").forward(request,response);
        }else if(action.equals("content")){
            int insert = service.insert(tname, new Date(), Integer.parseInt(id));
            if(insert>0){
                System.out.println("添加成功");
                request.getRequestDispatcher("/newDao.jsp").forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
