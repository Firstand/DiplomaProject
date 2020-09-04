package com.hlbrc.entity;

import java.util.Date;

public class Goodsclass {
    private Integer goodsClassId;

    private String name;

    private Integer featherPk;

    private Integer isVisible;

    private Integer isDefault;

    private Integer sort;

    private String imgPath;

    private Date createTime;

    private Date updateTime;

    private Integer creManagerId;

    private Integer updManagerId;

    public Integer getGoodsClassId() {
        return goodsClassId;
    }

    public void setGoodsClassId(Integer goodsClassId) {
        this.goodsClassId = goodsClassId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getFeatherPk() {
        return featherPk;
    }

    public void setFeatherPk(Integer featherPk) {
        this.featherPk = featherPk;
    }

    public Integer getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Integer isVisible) {
        this.isVisible = isVisible;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
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