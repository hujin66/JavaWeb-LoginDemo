package com.company;

import java.sql.*;

public class SqlLiteHelper {

    static Connection con;
    static Statement stat;
    static String db = "c:/Users/foyou/IdeaProjects/JavaWeb01/db/user.db";

    //todo 可以使用配置文件
    static {
        try {
            Class.forName("org.sqlite.JDBC");
            //建立连接，不存在则新建
            con = DriverManager.getConnection("jdbc:sqlite://" + db);
            //创建连接对象
            stat = con.createStatement();
            //检查user表是否存在
            ResultSet resultSet = stat.executeQuery("SELECT name FROM sqlite_master WHERE type = 'table' AND name = 'user'");
            if (resultSet.next()) {
                System.out.println("user表存在");
            } else {
                System.out.println("user表不存在，创建====");
                String sql = "CREATE TABLE 'user' ('name' TEXT NOT NULL,'password' TEXT,PRIMARY KEY ('name'));";
                //创建表
                stat.executeUpdate(sql);
                System.out.println("user表创建成功====");
            }
            System.out.println("SqlLiteHelper.static initializer");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //todo 临时===需要重新构建锁机制
    public static synchronized boolean insert(UserObject user) {
        String sql = "INSERT INTO user VALUES('" +
                user.getUser() +
                "','" +
                user.getPassword() +
                "')";
        System.out.println("用户注册：" + sql);
        try {
            if (stat.executeUpdate(sql) == 1) {
                return true;
            } else {
                new Throwable("奇怪===").printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            //用户已存在
            return false;
        }
    }

    public static synchronized boolean delete(UserObject user) {
        String sql = "DELETE FROM 'user' WHERE name = '" +
                user.getUser() +
                "'";
        System.out.println("用户注销:" + sql);
        try {
            if (stat.executeUpdate(sql) == 1) {
                return true;
            } else {
                //用户不存在
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    public static synchronized boolean select(UserObject user) {
        String sql = "SELECT name FROM user WHERE name= '" +
                user.getUser() +
                "' and password = '" +
                user.getPassword() +
                "'";
        try {
            ResultSet resultSet = stat.executeQuery(sql);
            if (resultSet.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
