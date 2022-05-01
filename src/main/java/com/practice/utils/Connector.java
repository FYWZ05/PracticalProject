package com.practice.utils;


import java.sql.*;

/**
 * 连接数据库工具类
 */
public class Connector {
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/db_practice?characterEncoding=utf-8";
    private final String JDBC_USER = "root";
    private final String JDBC_PASSWORD = root

    /**
     * 获取数据库连接
     * @return 数据库连接对象
     */
    public Connection getConnection() {
        Connection conn;
        try {
            Class.forName(JDBC_DRIVER);// 加载驱动
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);// 链接数据库
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
        return conn;
    }

    /**
     * 关闭资源
     * @param resultSet 结果集
     * @param statement 描述
     * @param conn 链接
     * @return 关闭结果     -1为关闭异常      0为正常关闭
     */
    public int close(ResultSet resultSet, Statement statement, Connection conn){
        try{
            if (resultSet != null){
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }
            if (conn != null){
                conn.close();
            }
            return 0;
        }catch (Exception e){
            return -1;
        }
    }
}
