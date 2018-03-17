package Servlet;

import entity.login;
import service.UserService;
import service.serviceimpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by leon on 2018/1/30.
 */
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("username");
        System.out.println(name);
        String pwd=request.getParameter("upwd");
        UserService service=new UserServiceImpl();
        login logins=new login();
        logins.setUsername(name);
        logins.setUpwd(pwd);
        try {
            login users = service.Users(logins);
            //request.getSession().setAttribute("users",users);
            if(users!=null){
                if(logins.getUsername()!=null){
                    request.getSession().setAttribute("user",users);
                    request.getRequestDispatcher("/pages/Index.jsp").forward(request,response);
                }else{
                    response.sendRedirect(request.getContextPath()+"/pages/login.jsp");
                }
            }else{
                response.sendRedirect(request.getContextPath()+"/pages/login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
