package com.demo;

import com.dao.Dao;
import com.dao.DaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteShoppingServlet")
public class DeleteShoppingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        int id = Integer.parseInt(request.getParameter("id"));
        //调用dao
        Dao dao = new DaoImpl();
        int i = dao.deleteShopping(id);
        if (i == 1){
            response.sendRedirect(request.getContextPath()+"/shoppingServlet");
        }else {
            request.setAttribute("del","删除失败");
            request.getRequestDispatcher("shopping.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
