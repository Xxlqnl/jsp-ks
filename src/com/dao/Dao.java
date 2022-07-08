package com.dao;

import com.domain.Admin;
import com.domain.Books;
import com.domain.Shopping;
import com.domain.User;

import java.util.List;

public interface Dao {
    //用户登录
    public User login(User user);
    //用户注册
    public int addUser(User user);
    //页面
    public List<Books> selectBooks(String classly);
    //添加图书
    public int addBook(Books books);
    //查询图书详情
    public Books selectDetail(String name);
    //加入购物车
    public int addShopping(Shopping shopping);
    //遍历购物车
    public List<Shopping> selectShopping(String username);
    //删除购物车
    public int deleteShopping(int id);
    //清空购物车
    public int deleteS(String username);
    //管理员登录
    public Admin admin(Admin admin);
    //遍历图书
    public List<Books> BOOKS_LIST();
    //删除图书
    public int deleteBooks(String name);
    //修改图书信息
    public int modifyBook(Books books);
    //遍历用户
    public List<User> selectUser();
    //修改用户信息
    public int modifyUser(User user);
    //删除用户
    public int deleteUser(int id);
}
