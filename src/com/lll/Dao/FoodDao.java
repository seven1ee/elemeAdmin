package com.lll.Dao;

import com.lll.Domain.Food;

import java.util.List;

public interface FoodDao
{
    public List<Food> showFoodlist(Integer BusinessId);
    public Food searchFood(Integer FoodId);
    public Integer saveFood(Food food);
    public Integer updateFood(Food food);
    public Integer removeFood(Integer foodId);
}
