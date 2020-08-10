package com.lll.Dao.Impl;

import com.lll.Dao.FoodDao;
import com.lll.Domain.Food;
import com.lll.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FoodDaoImpl implements FoodDao
{
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    @Override
    public List<Food> showFoodlist(Integer BusinessId)
    {
        List<Food> list=null;
        String sql="select * from food where businessid=?";
        try{
            conn= JDBCUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,BusinessId);
            rs=pstmt.executeQuery();
            while (rs.next())
            {
                Food food=new Food();
                food.setFooId(rs.getInt("FoodId"));
                food.setFoodName(rs.getString("foodname"));
                food.setFoodExplain(rs.getString("foodexplain"));
                food.setFoodprice(rs.getDouble("foodprice"));
                food.setBusinessId(rs.getInt("businessid"));
                list.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
        return list;
    }

    @Override
    public Food searchFood(Integer FoodId)
    {
        Food food=null;
        String sql="select * from food where foodid =?";
        try
        {
            conn=JDBCUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,FoodId);
            rs=pstmt.executeQuery();
            food.setFooId(rs.getInt("FoodId"));
            food.setFoodName(rs.getString("foodname"));
            food.setFoodExplain(rs.getString("foodexplain"));
            food.setFoodprice(rs.getDouble("foodprice"));
            food.setBusinessId(rs.getInt("businessid"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
        return food;
    }

    @Override
    public Integer saveFood(Food food)
    {
        int id=0;
        String sql="insert into food (foodname,foodexplain,foodprice) values(?,?,?)";
        try
        {
            conn=JDBCUtils.getConnection();
            pstmt=conn.prepareStatement(sql,pstmt.RETURN_GENERATED_KEYS);
            pstmt.setString(1,food.getFoodName());
            pstmt.setString(2,food.getFoodExplain());
            pstmt.setDouble(3,food.getFoodprice());
            pstmt.executeUpdate();
            rs=pstmt.getGeneratedKeys();
            if(rs.next())
            {
                id=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
        return id;
    }

    @Override
    public Integer updateFood(Food food)
    {
        int result=0;
        String sql="update food set foodname=?,foodexplain=?,foodprice=? where foodid=?";
        try
        {
            conn=JDBCUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,food.getFoodName());
            pstmt.setString(2,food.getFoodExplain());
            pstmt.setDouble(3,food.getFoodprice());
            pstmt.setInt(4,food.getFooId());
            result=pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.close(pstmt,conn);
        }
        return result;
    }

    @Override
    public Integer removeFood(Integer foodId)
    {
        String sql="delete from food where fooid =?";
        int result=0;
        try
        {
            conn=JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,foodId);
            result=pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.close(pstmt,conn);
        }
        return result;
    }
}
