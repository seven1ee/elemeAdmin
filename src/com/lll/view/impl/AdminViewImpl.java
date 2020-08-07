package com.lll.view.impl;

import com.lll.Dao.AdminDao;
import com.lll.Dao.Impl.AdminDaoImpl;
import com.lll.Domain.Admin;
import com.lll.view.AdminView;

import java.util.Scanner;

public class AdminViewImpl implements AdminView
{
    private Scanner input=new Scanner(System.in);
    @Override
    public Admin login()
    {
        System.out.println("请输入管理员用户名");
        String adminname=input.next();
        System.out.println("请输入管理员密码");
        String password =input.next();
        AdminDao adminDao = new AdminDaoImpl();
//      Admin admin = dao.getAdminByNameByPass(adminName, password);
//      return admin;
        return adminDao.getAdminBynameBypw(adminname,password);
    }
}
