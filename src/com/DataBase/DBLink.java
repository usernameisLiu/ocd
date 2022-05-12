package com.DataBase;

import java.sql.*;

public class DBLink {
    public Connection conn = null;
    public Statement stmt = null;
    public ResultSet rs = null;
    private static String dbDriver = "com.mysql.jdbc.Driver";
    private static String dbUrl = "jdbc:mysql://localhost:3306/javaweb?characterEncoding=UTF-8";
    private static String dbUser = "root";
    private static String dbPwd = "";

    //打开数据库连接
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(dbDriver);   //加载数据库驱动
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);  //建立数据库连接对象
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (conn == null) {
            System.err.println("警告:数据库连接失败!");
        }
        return conn;
    }

    //读取结果集
    public ResultSet doQuery(String sql)  //执行select
    {
        try {
            conn = DBLink.getConnection();
            stmt = conn.createStatement
                    (ResultSet.TYPE_SCROLL_INSENSITIVE,   // 此参数支持读取结果集时“双向滚动”
                            ResultSet.CONCUR_READ_ONLY);       //此参数为“只读”
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //更新数据
    public int doUpdate(String sql) {
        int result = 0;
        try {
            conn = DBLink.getConnection();
            stmt = conn.createStatement
                    (ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
            result = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            result = 0;
        }
        return result;
    }

    //关闭数据库连接
    public void closeConnection() {
        try {
            if (rs != null)
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (stmt != null)
                stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //关闭数据库
    public void closeall(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}