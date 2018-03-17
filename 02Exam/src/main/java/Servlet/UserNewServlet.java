package Servlet;

import com.alibaba.fastjson.JSON;
import entity.login;
import service.UserService;
import service.serviceimpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leon on 2018/2/6.
 */
public class UserNewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService service=new UserServiceImpl();
        try {
            List<login> all = service.findAll();
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("total",all.size());
            map.put("rows",all);
            String s = JSON.toJSONString(map);
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
