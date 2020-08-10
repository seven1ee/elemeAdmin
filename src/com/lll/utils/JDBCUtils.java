package com.lll.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * druid连接池
 */
public class JDBCUtils
{   //定义成员变量datasource 可以切换不同的连接池
    private static DataSource ds;

    static {
        try {
            // 1、加载配置文件
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            // 2. 获取 定义成员变量DataSource
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() throws SQLException
    {
        return ds.getConnection();
    }

    /**
     * 释放资源
     */
    public static void close(PreparedStatement stmt, Connection conn)
    {
//        if (stmt != null) {
//            try {
//                stmt.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        if (conn != null) {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        if (rs != null) {
//            try {
//                rs.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }clo
        close(null,stmt,conn);
    }
    public static void close(ResultSet rs, PreparedStatement stmt, Connection conn)
    {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 获取连接时方法
     */
    public static DataSource getDataSource()
    {
        return ds;
    }
}

