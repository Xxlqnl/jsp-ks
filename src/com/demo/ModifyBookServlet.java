package com.demo;

import com.dao.Dao;
import com.dao.DaoImpl;
import com.domain.Books;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet("/modifyBookServlet")
@MultipartConfig
public class ModifyBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取表单数据
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String price1 = request.getParameter("price");
        int price = Integer.parseInt(price1);
        String classly = request.getParameter("classly");
        String detail = request.getParameter("detail");
        Part img = request.getPart("img");

        //将图片存入指定位置
        String path = this.getServletContext().getRealPath("/image");
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        String header = img.getHeader("content-disposition");
        String fname = header.substring(header.lastIndexOf("."), header.length() - 1);
        img.write(path+"\\"+name+fname);
        //封装数据
        Books books = new Books();
        books.setId(id);
        books.setName(name);
        books.setImg("image\\"+name+fname);
        books.setPrice(price);
        books.setClassly(classly);
        books.setDetail(detail);
        //调用dao
        Dao dao = new DaoImpl();
        dao.modifyBook(books);
        response.sendRedirect(request.getContextPath()+"/adindexServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
