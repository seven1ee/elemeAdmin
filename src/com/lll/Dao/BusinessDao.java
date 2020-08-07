package com.lll.Dao;

import com.lll.Domain.Business;

import java.util.List;

public interface BusinessDao
{
    //显示商家列表   可选输入businessName和BusinessAddress
    public List<Business> showBusiness(String businessName,String businessaddr);
    public Integer saveBusiness(String bussiness);
}
