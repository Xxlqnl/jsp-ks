package com.demo;

import com.dao.Dao;
import com.dao.DaoImpl;
import com.domain.Books;
import com.domain.Shopping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addShoppingServlet")
public class AddShoppingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取数据
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String name = request.getParameter("name");
        int number = Integer.parseInt(request.getParameter("number"));

        //调用dao
        Dao dao = new DaoImpl();
        Books books = dao.selectDetail(name);
        //封装数据
        Shopping shopping = new Shopping();
        shopping.setUsername(username);
        shopping.setImg(books.getImg());
        shopping.setName(books.getName());
        shopping.setNumber(number);

        shopping.setPrice(number*books.getPrice());

        //调用dao
        int i = dao.addShopping(shopping);
        if (i == 1){
            //System.out.println(shopping.getPrice());
                response.sendRedirect(request.getContextPath()+"/shoppingServlet");
        }else {
            request.setAttribute("shop","加入购物车失败");
            request.getRequestDispatcher("details.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
