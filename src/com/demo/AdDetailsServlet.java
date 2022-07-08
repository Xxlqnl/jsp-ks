package com.demo;

import com.dao.Dao;
import com.dao.DaoImpl;
import com.domain.Books;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adDetailsServlet")
public class AdDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取数据
        String name = request.getParameter("name");
        //调用dao
        Dao dao = new DaoImpl();
        Books books = dao.selectDetail(name);
        request.setAttribute("book",books);
        request.getRequestDispatcher("addetails.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
