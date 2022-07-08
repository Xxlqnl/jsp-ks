package com.demo;

import com.dao.Dao;
import com.dao.DaoImpl;
import com.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyUserServlet")
public class ModifyUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //封装对象
        User u = new User();
        u.setId(id);
        u.setUsername(username);
        u.setPassword(password);
        //调用dao
        Dao dao = new DaoImpl();
        dao.modifyUser(u);
        response.sendRedirect(request.getContextPath()+"/userServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
