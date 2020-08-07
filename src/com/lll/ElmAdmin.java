package com.lll;

import com.lll.Domain.Admin;
import com.lll.view.AdminView;
import com.lll.view.impl.AdminViewImpl;
import com.lll.view.impl.BusinessViewImpl;

import java.util.Scanner;

public class ElmAdmin
{
    public static void main(String[] args)
    {
        work();
    }

    public static void work()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("*******************************************************");
        System.out.println("管理系统");
        System.out.println("*******************************************************");
        AdminView adminView = new AdminViewImpl();
        Admin admin = adminView.login();
        System.out.println(admin);
        if (admin != null) {
            System.out.println("登陆成功");
            int menu=0;
            while (menu!=5) {
                System.out.println("========= 1.所有商家列表=2.搜索商家=3.新建商家=4.删除商家=5.退出系统 =========\n");
                menu = input.nextInt();
                BusinessViewImpl bsView = new BusinessViewImpl();
                switch (menu) {
                    case 1:
                        System.out.println("所有商家列表：");
                        bsView.showBusinessAll();
                        break;
                    case 2:
                        System.out.println("搜索商家");
                        bsView.searchBusiness();
                        break;
                    case 3:
                        System.out.println("新建商家");
                        bsView.saveBusiness();
                        break;
                    case 4:
                        System.out.println("删除商家");
                        break;
                    case 5:
                        System.out.println();
                        break;
                    default:
                        System.out.println("没有这个功能");
                        break;
                }
            }
            System.out.println("欢迎下次光临");
        } else {
            System.out.println("登录失败");
        }
    }
}
