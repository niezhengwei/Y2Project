package Servlet;

import Service.IBookDaoService;
import entity.book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by leon on 2018/3/17.
 */
public class IBookServlet extends HttpServlet {
    IBookDaoService service;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
        String bookName = request.getParameter("bookName");
        String bookAuther = request.getParameter("bookAuther");
        String bookPrice = request.getParameter("bookPrice");
        book bo=new book();
        bo.setBookName(bookName);
        bo.setBookAuther(bookAuther);
        bo.setbookPrice(Integer.parseInt(bookPrice));

        //ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextSpringMybatis.xml");
        ApplicationContext context= WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
        IBookDaoService bean = (IBookDaoService)context.getBean("bookService");
        int i = bean.addBook(bo);
        if(i>0){
            request.getSession().setAttribute("list",i);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }else{
            response.sendRedirect(request.getContextPath()+"/addbook.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    public IBookDaoService getService() {
        return service;
    }

    public void setService(IBookDaoService service) {
        this.service = service;
    }
}
;