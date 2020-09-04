package com.hlbrc.entity;

import java.util.Date;

public class Product {
    private Integer productid;

    private Integer brandId;

    private Integer goodsClassId;

    private Integer storeId;

    private String name;

    private String goodmodel;

    private String salepoint;

    private String reductionstr;

    private String unittemplatedes;

    private Date createTime;

    private Date updateTime;

    private Integer creManagerId;

    private Integer updManagerId;

    private Integer minBuy;

    private Double money;

    private Double discount;

    private Integer intendedPopulation;

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getGoodsClassId() {
        return goodsClassId;
    }

    public void setGoodsClassId(Integer goodsClassId) {
        this.goodsClassId = goodsClassId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGoodmodel() {
        return goodmodel;
    }

    public void setGoodmodel(String goodmodel) {
        this.goodmodel = goodmodel == null ? null : goodmodel.trim();
    }

    public String getSalepoint() {
        return salepoint;
    }

    public void setSalepoint(String salepoint) {
        this.salepoint = salepoint == null ? null : salepoint.trim();
    }

    public String getReductionstr() {
        return reductionstr;
    }

    public void setReductionstr(String reductionstr) {
        this.reductionstr = reductionstr == null ? null : reductionstr.trim();
    }

    public String getUnittemplatedes() {
        return unittemplatedes;
    }

    public void setUnittemplatedes(String unittemplatedes) {
        this.unittemplatedes = unittemplatedes == null ? null : unittemplatedes.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCreManagerId() {
        return creManagerId;
    }

    public void setCreManagerId(Integer creManagerId) {
        this.creManagerId = creManagerId;
    }

    public Integer getUpdManagerId() {
        return updManagerId;
    }

    public void setUpdManagerId(Integer updManagerId) {
        this.updManagerId = updManagerId;
    }

    public Integer getMinBuy() {
        return minBuy;
    }

    public void setMinBuy(Integer minBuy) {
        this.minBuy = minBuy;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getIntendedPopulation() {
        return intendedPopulation;
    }

    public void setIntendedPopulation(Integer intendedPopulation) {
        this.intendedPopulation = intendedPopulation;
    }
}