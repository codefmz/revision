package com.gg.jdbc;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author 33863
 * @create 2021-12-20 19:44
 * @desc 复习jdbc
 **/
public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        //1.注册驱动
        Driver driver = new Driver();
        //2.得到连接
        //连接数据库的本质是通过 socket 连接
        String url = "jdbc:mysql://localhost:3306/mybaits?characterEncoding=utf-8";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "fmw");
        Connection connect = driver.connect(url, properties);
        //3.执行sql
        String sql = "insert into tab1_employee(id, last_name, gender, email) " +
                " values(null, '王二锤', '男', 'wrc@qq.com')";
        //statement:用于执行sql，并返回执行对象
        Statement statement = connect.createStatement();
        int i = statement.executeUpdate(sql);
        System.out.println(i);
        //4.关闭连接
        statement.close();
        connect.close();
    }

    @Test
    public void getConnection1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        // 使用反射 动态加载 driver, 可以加载不同的driver
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        String url = "jdbc:mysql://localhost:3306/mybaits?characterEncoding=utf-8";
        String user = "root";
        String password = "fmw";
        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("connection = " + connection);
    }
    @Test
    public void getConnection2() throws ClassNotFoundException, SQLException, IOException {
//        Class.forName("com.mysql.jdbc.Driver");
//        String url = "jdbc:mysql://localhost:3306/mybaits?characterEncoding=utf-8";
//        String user = "root";
//        String password = "fmw";
        Properties properties = new Properties();
        //没打包，运行时还是遵循idea 的目录结构的
        properties.load(new FileInputStream("resources/mysql.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("connection = " + connection);
    }
}
