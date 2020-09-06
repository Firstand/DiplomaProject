package com.hlbrc.entity;

import java.util.Date;

public class User {
    private Integer userId;

    private Integer storeId;

    private Integer accountGroupId;

    private String userName;

    private String userSex;

    private Integer userAge;

    private String userBirthTime;

    private String userTel;

    private String userIdcardNum;

    private Double userMoney;

    private Date updateTime;

    private Integer userState;

    private String userAddress;

    private String userGrade;

    private Double userConsume;

    private Double userIntegral;

    private Integer userConsumeNumber;

    private Date userRegistTime;

    private Integer updManagerId;

    private Integer creManagerId;

    private String userNo;

    private String fixedLineTelephonne;

    private String fromEnterpriseId;

    private Date firstLoginTime;

    private String firstLoginIp;

    private Date lastLoginTime;

    private String lastLoginIp;

    private Integer isTax;

    private Integer disable;

    private Double orderRefundRate;

    private Double rewardAmountRate;

    private String password;

    private String email;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getAccountGroupId() {
        return accountGroupId;
    }

    public void setAccountGroupId(Integer accountGroupId) {
        this.accountGroupId = accountGroupId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserBirthTime() {
        return userBirthTime;
    }

    public void setUserBirthTime(String userBirthTime) {
        this.userBirthTime = userBirthTime == null ? null : userBirthTime.trim();
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }

    public String getUserIdcardNum() {
        return userIdcardNum;
    }

    public void setUserIdcardNum(String userIdcardNum) {
        this.userIdcardNum = userIdcardNum == null ? null : userIdcardNum.trim();
    }

    public Double getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(Double userMoney) {
        this.userMoney = userMoney;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public String getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(String userGrade) {
        this.userGrade = userGrade == null ? null : userGrade.trim();
    }

    public Double getUserConsume() {
        return userConsume;
    }

    public void setUserConsume(Double userConsume) {
        this.userConsume = userConsume;
    }

    public Double getUserIntegral() {
        return userIntegral;
    }

    public void setUserIntegral(Double userIntegral) {
        this.userIntegral = userIntegral;
    }

    public Integer getUserConsumeNumber() {
        return userConsumeNumber;
    }

    public void setUserConsumeNumber(Integer userConsumeNumber) {
        this.userConsumeNumber = userConsumeNumber;
    }

    public Date getUserRegistTime() {
        return userRegistTime;
    }

    public void setUserRegistTime(Date userRegistTime) {
        this.userRegistTime = userRegistTime;
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

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public String getFixedLineTelephonne() {
        return fixedLineTelephonne;
    }

    public void setFixedLineTelephonne(String fixedLineTelephonne) {
        this.fixedLineTelephonne = fixedLineTelephonne == null ? null : fixedLineTelephonne.trim();
    }

    public String getFromEnterpriseId() {
        return fromEnterpriseId;
    }

    public void setFromEnterpriseId(String fromEnterpriseId) {
        this.fromEnterpriseId = fromEnterpriseId == null ? null : fromEnterpriseId.trim();
    }

    public Date getFirstLoginTime() {
        return firstLoginTime;
    }

    public void setFirstLoginTime(Date firstLoginTime) {
        this.firstLoginTime = firstLoginTime;
    }

    public String getFirstLoginIp() {
        return firstLoginIp;
    }

    public void setFirstLoginIp(String firstLoginIp) {
        this.firstLoginIp = firstLoginIp == null ? null : firstLoginIp.trim();
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    public Integer getIsTax() {
        return isTax;
    }

    public void setIsTax(Integer isTax) {
        this.isTax = isTax;
    }

    public Integer getDisable() {
        return disable;
    }

    public void setDisable(Integer disable) {
        this.disable = disable;
    }

    public Double getOrderRefundRate() {
        return orderRefundRate;
    }

    public void setOrderRefundRate(Double orderRefundRate) {
        this.orderRefundRate = orderRefundRate;
    }

    public Double getRewardAmountRate() {
        return rewardAmountRate;
    }

    public void setRewardAmountRate(Double rewardAmountRate) {
        this.rewardAmountRate = rewardAmountRate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}