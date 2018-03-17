package Servlet;

import entity.result;
import service.UserService;
import service.serviceimpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by leon on 2018/2/3.
 */
public class TalkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String classname = request.getParameter("classname");
        UserService user=new UserServiceImpl();
        try {
            List<result> list = user.showAll(classname);
            int max = user.Max(classname);
            int min = user.Min(classname);
            int avg = user.avg(classname);
            request.setAttribute("maxs",max);
            request.setAttribute("mins",min);
            request.setAttribute("avgs",avg);
            request.setAttribute("lists",list);
            request.getRequestDispatcher("/pages/showAll.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
