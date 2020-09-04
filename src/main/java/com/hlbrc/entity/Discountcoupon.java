package com.hlbrc.entity;

import java.util.Date;

public class Discountcoupon {
    private Integer discountCouponId;

    private String name;

    private Double discountCouponMoney;

    private String description;

    private Date createTime;

    private Date updateTime;

    private Integer creManagerId;

    private Integer updManagerId;

    public Integer getDiscountCouponId() {
        return discountCouponId;
    }

    public void setDiscountCouponId(Integer discountCouponId) {
        this.discountCouponId = discountCouponId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getDiscountCouponMoney() {
        return discountCouponMoney;
    }

    public void setDiscountCouponMoney(Double discountCouponMoney) {
        this.discountCouponMoney = discountCouponMoney;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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
}