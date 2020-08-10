package com.lll.Dao.Impl;

import com.lll.Dao.BusinessDao;
import com.lll.Domain.Business;
import com.lll.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessDaoImpl implements BusinessDao
{
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    public List<Business> showBusiness(String businessName, String businessaddr)
    {
        StringBuffer sql = new StringBuffer("select * from business ");
        List<Business> blist = new ArrayList<>();
        if (businessName != null && !businessName.equals("")) {//传入了商家名
            sql.append("where businessName like '%").append(businessName).append("%'");
            System.out.println(sql);
        }
        if (businessaddr != null && !businessaddr.equals("")) {
            sql.append(" and businessAddress like '%").append(businessaddr).append("%'");
            System.out.println(sql);
        }
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Business business = new Business();
                business.setbId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
                business.setbName(rs.getString("businessname"));
                business.setbAddr(rs.getString("businessAddress"));
                business.setbExp(rs.getString("businessexplain"));
                business.setsPrice(rs.getDouble("starprice"));
                business.setDlPrice(rs.getDouble("deliveryprice"));
                blist.add(business);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return blist;
    }

    @Override
    public Integer saveBusiness(String bussiness)
    {
        int bussinessId = 0;
        String sql = "insert into business(businessName,password) values(?,'123456')";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, bussiness);
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                bussinessId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return bussinessId;
    }

    @Override
    public Business login(String businessName, String password)
    {
        Business business = null;
        String sql = "select * from business where businessName = ? and password = ?";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, businessName);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                business = new Business();
                business.setbName(rs.getString("businessname"));
                business.setPassword(rs.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        System.out.println(business);
        return business;
    }


    @Override
    public int deleteBusiness(int businessId)
    {
        String sql = "delete from business where businessId =?";
        int resule = 0;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, businessId);
            resule = pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            resule = 0;
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
        return resule;
    }

    @Override
    public int updateBusiness(Business business)
    {
        int result = 0;
        String sql = "update business set businessName=?,businessAddress=?,businessExplain=?,starPrice=?,deliveryPrice=? where businessId=?";
        try
        {
            conn=JDBCUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,business.getbName());
            pstmt.setString(2,business.getbAddr());
            pstmt.setString(3,business.getbExp());
            pstmt.setDouble(4,business.getsPrice());
            pstmt.setDouble(5,business.getDlPrice());
            pstmt.setInt(6,business.getbId());
            result=pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.close(pstmt,conn);
        }
        return result;
    }
}
