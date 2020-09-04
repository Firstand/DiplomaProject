package com.hlbrc.entity;

import java.util.Date;

public class Usercollect {
    private Integer userCollectId;

    private Integer productid;

    private Date updateTime;

    private Integer updManagerId;

    private Integer creManagerId;

    private Date creatTime;

    public Integer getUserCollectId() {
        return userCollectId;
    }

    public void setUserCollectId(Integer userCollectId) {
        this.userCollectId = userCollectId;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdManagerId() {
        return updManagerId;
    }

    public void setUpdManagerId(Integer updManagerId) {
        this.updManagerId = updManagerId;
    }

    public Integer getCreManagerId() {
        return creManagerId;
    }

    public void setCreManagerId(Integer creManagerId) {
        this.creManagerId = creManagerId;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}