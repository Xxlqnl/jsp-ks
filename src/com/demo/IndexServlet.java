package com.demo;

import com.dao.Dao;
import com.dao.DaoImpl;
import com.domain.Books;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/indexServlet")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取数据
        String classly = request.getParameter("classly");
        if (classly.equals("1")){
            classly="儿童读物";
        }
        //调用dao
        Dao dao = new DaoImpl();
        List<Books> books = dao.selectBooks(classly);
        request.setAttribute("book",books);
        switch (classly){
            case "儿童读物":
                request.getRequestDispatcher("index.jsp").forward(request,response);
                break;
            case "青年读物":
                request.getRequestDispatcher("index1.jsp").forward(request,response);
                break;
            case "科普百科":
                request.getRequestDispatcher("index2.jsp").forward(request,response);
                break;
            case "卡通动漫":
                request.getRequestDispatcher("index3.jsp").forward(request,response);
                break;
            case "名著宝藏":
                request.getRequestDispatcher("index4.jsp").forward(request,response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
