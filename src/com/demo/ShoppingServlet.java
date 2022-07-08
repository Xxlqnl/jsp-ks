package com.demo;

import com.dao.Dao;
import com.dao.DaoImpl;
import com.domain.Shopping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/shoppingServlet")
public class ShoppingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取数据
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        //调用dao
        Dao dao = new DaoImpl();
        int sum = 0;
        List<Shopping> shoppings = dao.selectShopping(username);
        for (Shopping shopping : shoppings) {
            sum += shopping.getPrice();
        }
        request.setAttribute("shopping",shoppings);
        request.setAttribute("sum",sum);
        //System.out.println(request.getAttribute("sum"));
        request.getRequestDispatcher("shopping.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
