package com.hlbrc.entity;

import java.util.Date;

public class Goodspackaging {
    private Integer goodsPackagingId;

    private Integer productid;

    private String unitName;

    private String unitTemplateName;

    private String pcs;

    private String unitTemplateDes;

    private Date createTime;

    private Date updateTime;

    private Integer creManagerId;

    private Integer updManagerId;

    public Integer getGoodsPackagingId() {
        return goodsPackagingId;
    }

    public void setGoodsPackagingId(Integer goodsPackagingId) {
        this.goodsPackagingId = goodsPackagingId;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    public String getUnitTemplateName() {
        return unitTemplateName;
    }

    public void setUnitTemplateName(String unitTemplateName) {
        this.unitTemplateName = unitTemplateName == null ? null : unitTemplateName.trim();
    }

    public String getPcs() {
        return pcs;
    }

    public void setPcs(String pcs) {
        this.pcs = pcs == null ? null : pcs.trim();
    }

    public String getUnitTemplateDes() {
        return unitTemplateDes;
    }

    public void setUnitTemplateDes(String unitTemplateDes) {
        this.unitTemplateDes = unitTemplateDes == null ? null : unitTemplateDes.trim();
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