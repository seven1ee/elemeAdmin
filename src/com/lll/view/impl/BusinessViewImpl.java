package com.lll.view.impl;

import com.lll.Dao.BusinessDao;
import com.lll.Dao.Impl.BusinessDaoImpl;
import com.lll.Domain.Business;
import com.lll.view.BusinessView;

import java.util.List;
import java.util.Scanner;

public class BusinessViewImpl implements BusinessView
{
    Scanner input=new Scanner(System.in);
    @Override
    public void showBusinessAll()
    {
        BusinessDaoImpl dao = new BusinessDaoImpl();
        List<Business> list=dao.showBusiness(null,null);
        for (Business b:list) {
            System.out.println(b.getbId()+"\t"+b.getbName());
        }
    }

    @Override
    public void searchBusiness()
    {
        String businessName="";
        String businessAddr="";
        System.out.println("是否需要输入商家名称关键字（y/n）：");
        String word=input.next();
        if(word.equals("y"))
        {
            System.out.println("请输入商家名称关键字");
            businessName=input.next();
        }
        if(word.equals("n"))
        {
            businessName=null;
        }
        System.out.println("是否需要输入商家地址关键字（y/n）");
        word=input.next();
        if(word.equals("y"))
        {
            System.out.println("请输入商家地址关键字：");
            businessAddr=input.next();
        }
        if(word.equals("n"))
        {
            businessAddr=null;
        }
        BusinessDao dao=new BusinessDaoImpl();
        List<Business> list=dao.showBusiness(businessName,businessAddr);
        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
        for (Business b:list
             ) {
            System.out.println(b.getbId()+"\t"+b.getbName()+"\t"+b.getbAddr()+"\t"+b.getbExp()+"\t"+b.getsPrice()+"\t"+b.getDlPrice());
        }
    }

    @Override
    public void saveBusiness()
    {
        BusinessDaoImpl dao = new BusinessDaoImpl();
        System.out.println("请输入商家名称：");
        Integer id=dao.saveBusiness(input.next());
        if (id>0)
        {
            System.out.println("添加成功，编号为"+id);
        }
        else {
            System.out.println("添加失败");
        }

    }
}
