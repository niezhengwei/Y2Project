package servlet;

import com.alibaba.fastjson.JSON;
import entity.User;
import service.loginService;
import service.serviceImpl.loginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by leon on 2018/2/25.
 */
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        loginService los = new loginServiceImpl();
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            User user = los.loginservice(username, password);
            if (action.equals("login")) {
                request.getSession().setAttribute("users", user);
                request.getRequestDispatcher("/pages/welcome.jsp").forward(request, response);
            } else if (action.equals("exit")) {
                request.getSession().removeAttribute("users");
                response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
            } else if(action.equals("list")){
                List<User> userList = los.findAllservice();
                String json = JSON.toJSONStringWithDateFormat(userList, "yyyy年MM月dd日");
                request.getSession().setAttribute("lists",userList);
                request.getRequestDispatcher("/pages/userList.jsp").forward(request, response);
            }else if(action.equals("upwd")) {
                request.getRequestDispatcher("/pages/password.jsp").forward(request, response);
            }else if(action.equals("upwds")){
                String oldPassword = request.getParameter("oldPassword");
                String newPassword = request.getParameter("newPassword");
                String reNewPassword = request.getParameter("reNewPassword");
                User users =(User) request.getSession().getAttribute("users");
                String userName = users.getUserName();
                String pwd = users.getUserPassword();
                if(newPassword.equals(reNewPassword)&&pwd.equals(oldPassword)){
                    int i = los.updateService(oldPassword, newPassword,userName);
                    request.getRequestDispatcher("/pages/success.jsp").forward(request,response);
                }else{
                    request.getRequestDispatcher("/pages/notsuccess.jsp").forward(request,response);
                    System.out.println("保存失败！");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
