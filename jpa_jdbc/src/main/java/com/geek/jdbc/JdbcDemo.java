package com.geek.jdbc;

import com.geek.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDemo {

    // 操作繁琐。
    // 占位符赋值麻烦。

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String sql = "insert into t_user (username, address) values (?, ?)";

//        DriverManager.registerDriver(new Driver());
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.142.135/new_schema?characterEncoding=UTF-8", "root", "root");

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        User user = new User();
        user.setUsername("geek");
        user.setAddress("武汉。");

        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getAddress());

        int i = preparedStatement.executeUpdate();

        System.out.println("i = " + i);

        preparedStatement.close();
        connection.close();
    }
}
