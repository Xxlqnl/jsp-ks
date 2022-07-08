package com.dao;

import com.domain.Admin;
import com.domain.Books;
import com.domain.Shopping;
import com.domain.User;
import com.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class DaoImpl implements Dao {
    //使用JdbcTemplate
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    //用户登录
    @Override
    public User login(User user) {
        try {
            //定义sql
            String sql = "select * from user where username = ? and password = ?";
            //执行sql
            User user1 = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUsername(), user.getPassword());
            //返回结果
            return user1;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    //用户注册
    @Override
    public int addUser(User user) {
        try {
            //定义sql
            String sql ="insert into user values(null,?,?)";
            //执行sql
            int update = template.update(sql, user.getUsername(), user.getPassword());
            return update;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return 0;
        }
    }
    //遍历图书
    @Override
    public List<Books> selectBooks(String classly) {
        //定义sql
        String sql = "select * from books where classly = ?";
        //执行sql
        List<Books> query = template.query(sql, new RowMapper<Books>() {
            @Override
            public Books mapRow(ResultSet resultSet, int i) throws SQLException {
                Books b = new Books();
                b.setImg(resultSet.getString("img"));
                b.setName(resultSet.getString("name"));
                b.setPrice(resultSet.getInt("price"));
                b.setDetail(resultSet.getString("detail"));
                return b;
            }
        }, classly);
        return query;
    }
    //添加图书
    @Override
    public int addBook(Books books) {
        try {
            //定义sql
            String sql = "insert into books values(null,?,?,?,?,?)";
            //执行sql
            int update = template.update(sql, books.getImg(),
                    books.getName(), books.getPrice(),
                    books.getClassly(), books.getDetail());
            //返回值
            return update;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return 0;
        }
    }
    //查询图书详情
    @Override
    public Books selectDetail(String name) {
        //定义sql
        String sql ="select * from books where name = ?";
        //执行sql
        Books query = template.queryForObject(sql, new BeanPropertyRowMapper<Books>(Books.class), name);
        //返回
        return query;
    }
    //加入购物车
    @Override
    public int addShopping(Shopping shopping) {
        try {
            //定义sql
            String sql = "insert into shopping values(null,?,?,?,?,?)";

            int update = template.update(sql,shopping.getImg(), shopping.getUsername(), shopping.getName(), shopping.getNumber(), shopping.getPrice());
            //返回值
            return update;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return 0;
        }
    }
    //遍历购物车
    @Override
    public List<Shopping> selectShopping(String username) {
        //定义sql
        String sql = "select * from shopping where username = ?";
        List<Shopping> query = template.query(sql, new RowMapper<Shopping>() {
            @Override
            public Shopping mapRow(ResultSet resultSet, int i) throws SQLException {
                Shopping shopping = new Shopping();
                shopping.setId(resultSet.getInt("id"));
                shopping.setImg(resultSet.getString("img"));
                shopping.setName(resultSet.getString("name"));
                shopping.setNumber(resultSet.getInt("number"));
                shopping.setPrice(resultSet.getInt("price"));
                return shopping;
            }
        }, username);
        return query;
    }
    //删除购物车
    @Override
    public int deleteShopping(int id) {
        //定义sql
        String sql = "delete from shopping where id = ?";
        //执行sql
        int update = template.update(sql, id);
        //返回执行结果
        return update;
    }
    //清空购物车
    @Override
    public int deleteS(String username) {
        //定义sql
        String sql = "delete from shopping where username = ?";
        //执行sql
        int update = template.update(sql, username);
        //返回执行结果
        return update;
    }
    //管理员登录
    @Override
    public Admin admin(Admin admin) {
        try {
            //定义sql
            String sql = "select * from admin where username = ? and password = ?";
            //执行sql
            Admin admin1 = template.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class), admin.getUsername(), admin.getPassword());
            return admin1;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    //遍历图书
    @Override
    public List<Books> BOOKS_LIST() {
        //定义sql
        String sql ="select * from books";
        //执行sql
        List<Books> query = template.query(sql, new RowMapper<Books>() {
            @Override
            public Books mapRow(ResultSet resultSet, int i) throws SQLException {
                Books b = new Books();
                b.setId(resultSet.getInt("id"));
                b.setImg(resultSet.getString("img"));
                b.setName(resultSet.getString("name"));
                b.setPrice(resultSet.getInt("price"));
                b.setClassly(resultSet.getString("classly"));
                b.setDetail(resultSet.getString("detail"));
                return b;
            }
        });
        return query;
    }
    //删除图书
    @Override
    public int deleteBooks(String name) {
        //定义sql
        String sql = "delete from books where name = ?";
        //执行sql
        int update = template.update(sql, name);
        //返回
        return update;
    }
    //修改图书
    @Override
    public int modifyBook(Books books) {
        //定义sql
        String sql ="update books set img = ? , name = ? , price = ? , classly = ? , detail = ? where id = ?";
        //执行sql
        int update = template.update(sql, books.getImg(), books.getName(), books.getPrice(), books.getClassly(), books.getDetail(), books.getId());
        //返回
        return update;
    }
    //遍历用户
    @Override
    public List<User> selectUser() {
        //定义sql
        String sql ="select * from user";
        //执行sql
        List<User> query = template.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User u = new User();
                u.setId(resultSet.getInt("id"));
                u.setUsername(resultSet.getString("username"));
                u.setPassword(resultSet.getString("password"));
                return u;
            }
        });
        return query;
    }
    //修改用户
    @Override
    public int modifyUser(User user) {
        //定义sql
        String sql = "update user set username = ? , password = ? where id = ?";
        //执行sql
        int update = template.update(sql, user.getUsername(), user.getPassword(), user.getId());
        //返回
        return update;
    }

    @Override
    public int deleteUser(int id) {
        //定义sql
        String sql ="delete from user where id =?";
        //执行sql
        int update = template.update(sql, id);
        return update;
    }
}
