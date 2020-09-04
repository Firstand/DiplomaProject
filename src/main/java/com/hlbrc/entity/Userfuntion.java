package com.hlbrc.entity;

import java.util.Date;

public class Userfuntion {
    private Integer userFuntionId;

    private Integer accountGroupId;

    private String userFuntionNo;

    private String userFuntionName;

    private Date updateTime;

    private Integer updManagerId;

    private Integer creManagerId;

    private Date creatTime;

    public Integer getUserFuntionId() {
        return userFuntionId;
    }

    public void setUserFuntionId(Integer userFuntionId) {
        this.userFuntionId = userFuntionId;
    }

    public Integer getAccountGroupId() {
        return accountGroupId;
    }

    public void setAccountGroupId(Integer accountGroupId) {
        this.accountGroupId = accountGroupId;
    }

    public String getUserFuntionNo() {
        return userFuntionNo;
    }

    public void setUserFuntionNo(String userFuntionNo) {
        this.userFuntionNo = userFuntionNo == null ? null : userFuntionNo.trim();
    }

    public String getUserFuntionName() {
        return userFuntionName;
    }

    public void setUserFuntionName(String userFuntionName) {
        this.userFuntionName = userFuntionName == null ? null : userFuntionName.trim();
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