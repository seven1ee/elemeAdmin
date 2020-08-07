package com.lll.Domain;

public class Business
{
    private Integer bId;
    private String password;
    private String bName;
    private String bAddr;
    private String bExp;
    private Double sPrice;
    private Double dlPrice;

    public Business()
    {
    }

    public Business(Integer bId, String password, String bName, String bAddr, String bExp, Double sPrice, Double dlPrice)
    {
        this.bId = bId;
        this.password = password;
        this.bName = bName;
        this.bAddr = bAddr;
        this.bExp = bExp;
        this.sPrice = sPrice;
        this.dlPrice = dlPrice;
    }

    public Integer getbId()
    {
        return bId;
    }

    public void setbId(Integer bId)
    {
        this.bId = bId;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getbName()
    {
        return bName;
    }

    public void setbName(String bName)
    {
        this.bName = bName;
    }

    public String getbAddr()
    {
        return bAddr;
    }

    public void setbAddr(String bAddr)
    {
        this.bAddr = bAddr;
    }

    public String getbExp()
    {
        return bExp;
    }

    public void setbExp(String bExp)
    {
        this.bExp = bExp;
    }

    public Double getsPrice()
    {
        return sPrice;
    }

    public void setsPrice(Double sPrice)
    {
        this.sPrice = sPrice;
    }

    public Double getDlPrice()
    {
        return dlPrice;
    }

    public void setDlPrice(Double dlPrice)
    {
        this.dlPrice = dlPrice;
    }

    @Override
    public String toString()
    {
        return "Business{" +
                "bId=" + bId +
                ", password='" + password + '\'' +
                ", bName='" + bName + '\'' +
                ", bAddr='" + bAddr + '\'' +
                ", bExp='" + bExp + '\'' +
                ", sPrice=" + sPrice +
                ", dlPrice=" + dlPrice +
                '}';
    }
}

