package com.lll;


import com.lll.Domain.Business;
import com.lll.view.BusinessView;
import com.lll.view.FoodView;
import com.lll.view.impl.BusinessViewImpl;
import com.lll.view.impl.FoodViewImpl;

import java.util.Scanner;


public class ElmBusiness
{
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        work();
    }

    public static void work()
    {

        System.out.println("-----------------------------------------------------------");
        System.out.println("|\t\t\t\t饿了么控制台版后台管理系统 V1.0\t\t\t\t|");
        System.out.println("-----------------------------------------------------------");

        // 调用商家登录
        BusinessView businessView = new BusinessViewImpl();
        Business business = businessView.login();

        if (business != null) {
            int menu = 0;
            System.out.println("~欢迎来到饿了么商家管理系统~");
            while (menu != 5) {

                // 创建一个菜单
                System.out.println("========= 一级菜单1.查看商家信息=2.修改商家信息=3.删除商家=4.所属商品管理=5.退出系统 =========");
                System.out.println("请选择相应的菜单编号");
                menu = input.nextInt();

                switch (menu) {
                    case 1:
                        businessView.showBusinessAll();
                        break;
                    case 2:
                        businessView.update();
                        break;
                    case 3:
                        System.out.println("1.删除商家");
                        BusinessView businessView1 = new BusinessViewImpl();
                        businessView1.shanchu();
                        break;
                    case 4:
                        foodManage();
                        break;
                    case 5:
                        System.out.println("========= 欢迎下次光临饿了么系统 =========");
                        break;
                    default:
                        System.out.println("没有这个菜单项");
                        break;
                }

            }


        } else {
            System.out.println("账号或密码有误请重新输入");
        }

    }

    public static void foodManage()
    {
        FoodView foodView = new FoodViewImpl();


        int menu = 0;
        while (menu != 5) {

            // 创建一个菜单
            System.out.println("========= 二级菜单（美食管理）1.查看食品列表2.新增食品 3.修改食品=4.删除食品=5.返回一级菜单 =========");
            System.out.println("请选择相应的菜单编号");
            menu = input.nextInt();

            switch (menu) {
                case 1:
                    foodView.showFood();
                    break;
                case 2:
                    foodView.saveFood();

                    break;
                case 3:
                    foodView.updateFood();

                    break;
                case 4:
                    foodView.removeFood();

                    break;
                case 5:
                    work();
                    break;
                default:
                    System.out.println("没有这个菜单项");
                    break;
            }

        }

    }
}








