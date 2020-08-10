package com.lll.view.impl;

import com.lll.Dao.FoodDao;
import com.lll.Dao.Impl.FoodDaoImpl;
import com.lll.Domain.Food;
import com.lll.view.FoodView;

import java.util.List;
import java.util.Scanner;

public class FoodViewImpl implements FoodView
{
    FoodDao foodDao=new FoodDaoImpl();
    Scanner scanner=new Scanner(System.in);
    @Override
    public void showFood()
    {

        System.out.println("请输入要查询的商家编号：");
        List<Food> list=foodDao.showFoodlist(scanner.nextInt());
        System.out.println(list);
    }

    @Override
    public void saveFood()
    {
        System.out.println("请输入要保存的商家信息：");
        Food food=new Food();
        System.out.println("姓名：");
        food.setFoodName(scanner.next());
        System.out.println("信息：");
        food.setFoodExplain(scanner.next());
        System.out.println("价格：");
        food.setFoodprice(scanner.nextDouble());
        int result=foodDao.saveFood(food);
        if(result==1)
        {
            System.out.println("保存成功");
        }
        else {
            System.out.println("保存失败");
        }

    }

    @Override
    public void updateFood()
    {
        Food food=new Food();
        System.out.println("请输入要修改信息的ID：");
        food.setFooId(scanner.nextInt());
        System.out.println("是否要输入姓名y/n");
        if(scanner.next().equals("y"))
        {
            System.out.println("请输入姓名：");
            food.setFoodName(scanner.next());
        }
        System.out.println("是否要输入价格y/n");
        if(scanner.next().equals("y"))
        {
            System.out.println("请输入价格：");
            food.setFoodprice(scanner.nextDouble());
        }
        int result=foodDao.updateFood(food);
        if(result>0)
        {
            System.out.println("修改成功");
        }
        else{
            System.out.println("修改失败");
        }
    }

    @Override
    public void removeFood()
    {
        System.out.println("请输入要删除的ID");
        int result=foodDao.removeFood(scanner.nextInt());
        if(result>0)
        {
            System.out.println("删除成功");
        }
        else {
            System.out.println("删除失败");
        }
    }
}
