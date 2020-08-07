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
        int bussinessId=0;
        String sql="insert into business(businessName,password) values(?,'123456')";
        try
        {
            conn=JDBCUtils.getConnection();
            pstmt=conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,bussiness);
            pstmt.executeUpdate();
            rs=pstmt.getGeneratedKeys();
            if(rs.next())
            {
                bussinessId=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
        return bussinessId;
    }
}
