package com.lll.view.impl;

import com.lll.Dao.BusinessDao;
import com.lll.Dao.Impl.BusinessDaoImpl;
import com.lll.Domain.Business;
import com.lll.view.BusinessView;

import java.util.List;
import java.util.Scanner;

public class BusinessViewImpl implements BusinessView
{
    Scanner input = new Scanner(System.in);

    @Override
    public Business login()
    {
        System.out.println("请输入商家名称：");
        String bname = input.next();
        System.out.println("请输入商家密码：");
        String password = input.next();
        BusinessDaoImpl businessDao = new BusinessDaoImpl();
        Business business = businessDao.login(bname, password);
        return business;
    }

    @Override
    public void showBusinessAll()
    {
        BusinessDaoImpl dao = new BusinessDaoImpl();
        List<Business> list = dao.showBusiness(null, null);
        for (Business b : list) {
            System.out.println(b.getbId() + "\t" + b.getbName());
        }
    }

    @Override
    public void searchBusiness()
    {
        String businessName = new String();
        String businessAddr = "";
        System.out.println("是否需要输入商家名称关键字（y/n）：");
        String word = input.next();
        if (word.equals("y")) {
            System.out.println("请输入商家名称关键字");
            businessName = input.next();
        }
        if (word.equals("n")) {
            businessName = null;
        }
        System.out.println("是否需要输入商家地址关键字（y/n）");
        word = input.next();
        if (word.equals("y")) {
            System.out.println("请输入商家地址关键字：");
            businessAddr = input.next();
        }
        if (word.equals("n")) {
            businessAddr = null;
        }
        BusinessDao dao = new BusinessDaoImpl();
        List<Business> list = dao.showBusiness(businessName, businessAddr);
        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
        for (Business b : list
        ) {
            System.out.println(b.getbId() + "\t" + b.getbName() + "\t" + b.getbAddr() + "\t" + b.getbExp() + "\t" + b.getsPrice() + "\t" + b.getDlPrice());
        }
    }

    @Override
    public void saveBusiness()
    {
        BusinessDaoImpl dao = new BusinessDaoImpl();
        System.out.println("请输入商家名称：");
        Integer id = dao.saveBusiness(input.next());
        if (id > 0) {
            System.out.println("添加成功，编号为" + id);
        } else {
            System.out.println("添加失败");
        }

    }

    @Override
    public void shanchu()
    {
        BusinessDao businessDao = new BusinessDaoImpl();
        System.out.println("请输入要删除的商家编号");
        int name = input.nextInt();
        System.out.println("确定要删除吗y/n");
        if (input.next().equals("y")) {
            int result = businessDao.deleteBusiness(name);
            if (result == 1)
            {
                System.out.println("删除成功");
            }
        }
        else System.out.println("删除失败");
    }

    @Override
    public void update()
    {
        int result=0;
        BusinessDao businessDao = new BusinessDaoImpl();
        System.out.println("请输入要修改的商家姓名");
        List<Business> businesses=businessDao.showBusiness(input.next(),null);
        Business business=businesses.get(0);
        System.out.println(business);
        System.out.println("请选择要修改的项目（商家姓名/商家位置）");
        String word=input.next();
        if (word.equals("商家姓名"))
        {
            System.out.println("请输入修改后的商家姓名：");
            business.setbName(input.next());
            result=businessDao.updateBusiness(business);
        }
        if (word.equals("商家位置"))
        {
            System.out.println("请输入修改后的商家位置");
            business.setbAddr(input.next());
            result=businessDao.updateBusiness(business);
        }

        System.out.println(result);
        if(result>0)
        {
            System.out.println("修改成功");
        }
        else System.out.println("修改失败");
    }

}
