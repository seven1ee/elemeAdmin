package com.lll.Dao.Impl;

import com.lll.Dao.AdminDao;
import com.lll.Domain.Admin;
import com.lll.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDaoImpl implements AdminDao
{
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    public Admin getAdminBynameBypw(String name, String password)
    {
        Admin admin = null;
        String sql = "select * from admin where adminName=? and password=?";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                admin = new Admin();
                admin.setAdminId(rs.getInt("adminid"));
                admin.setAdminName(rs.getString("adminname"));
                admin.setAdminName(rs.getString("password"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return admin;
    }
}
