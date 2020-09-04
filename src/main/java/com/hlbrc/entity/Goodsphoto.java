package com.hlbrc.entity;

import java.util.Date;

public class Goodsphoto {
    private Integer goodsPhotoId;

    private Integer productid;

    private String imgPath;

    private Integer isdefult;

    private Integer creManagerId;

    private Integer updManagerId;

    private Date createTime;

    private Date updateTime;

    public Integer getGoodsPhotoId() {
        return goodsPhotoId;
    }

    public void setGoodsPhotoId(Integer goodsPhotoId) {
        this.goodsPhotoId = goodsPhotoId;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }

    public Integer getIsdefult() {
        return isdefult;
    }

    public void setIsdefult(Integer isdefult) {
        this.isdefult = isdefult;
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
}