package com.demo;

import com.dao.Dao;
import com.dao.DaoImpl;
import com.domain.Admin;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/adLoginServlet")
public class AdLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取数据
        Map<String, String[]> map = request.getParameterMap();
        //封装数据
        Admin admin = new Admin();
        try {
            BeanUtils.populate(admin,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用dao
        Dao dao = new DaoImpl();
        Admin admin1 = dao.admin(admin);
        if (admin1 != null){
            HttpSession session = request.getSession();
            session.setAttribute("username","1");
            response.sendRedirect(request.getContextPath()+"/adindexServlet");
        }else {
            request.setAttribute("admin","账号或密码错误");
            request.getRequestDispatcher("adlogin.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
