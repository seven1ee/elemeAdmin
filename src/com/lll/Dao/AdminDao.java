package com.lll.Dao;

import com.lll.Domain.Admin;

public interface AdminDao
{
    public abstract Admin getAdminBynameBypw(String name, String password);
}
