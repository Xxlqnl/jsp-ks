package com.demo;

import com.dao.Dao;
import com.dao.DaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteBooksServlet")
public class DeleteBooksServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        String name = request.getParameter("name");
        //调用dao
        Dao dao = new DaoImpl();
        int i = dao.deleteBooks(name);
        response.sendRedirect(request.getContextPath()+"/adindexServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
