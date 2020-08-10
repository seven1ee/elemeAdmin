package com.lll.Domain;

public class Food
{
    private Integer fooId;
    private String foodName;
    private String foodExplain;
    private Double foodprice;
    private Integer businessId;

    public Food()
    {
    }

    public Integer getFooId()
    {
        return fooId;
    }

    public void setFooId(Integer fooId)
    {
        this.fooId = fooId;
    }

    public String getFoodName()
    {
        return foodName;
    }

    public void setFoodName(String foodName)
    {
        this.foodName = foodName;
    }

    public String getFoodExplain()
    {
        return foodExplain;
    }

    public void setFoodExplain(String foodExplain)
    {
        this.foodExplain = foodExplain;
    }

    public Double getFoodprice()
    {
        return foodprice;
    }

    public void setFoodprice(Double foodprice)
    {
        this.foodprice = foodprice;
    }

    public Integer getBusinessId()
    {
        return businessId;
    }

    public void setBusinessId(Integer businessId)
    {
        this.businessId = businessId;
    }
}
