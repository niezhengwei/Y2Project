package servlet;

import entity.news;
import entity.page;
import service.newDaoService;
import service.serviceImpl.newDaoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by leon on 2018/3/1.
 */
public class newDaoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        newDaoService service=new newDaoServiceImpl();
        String pageIndex = request.getParameter("pageIndex");
        int i=0;
        if(pageIndex==null){
            i=1;
        }else{
            i=Integer.parseInt(pageIndex);
        }
        page<news> alls = service.findAlls(i, 3);
        List<news> lists = alls.getLists();
        request.getSession().setAttribute("list",lists);
        request.getSession().setAttribute("page",alls);
        request.getRequestDispatcher("/newDao.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
