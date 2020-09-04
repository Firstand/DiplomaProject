package com.hlbrc.entity;

import java.util.Date;

public class Myorder extends MyorderKey {
    private Integer userId;

    private String storeName;

    private Double totalAmount;

    private Double receivablesAmount;

    private Integer totalNum;

    private Integer payType;

    private Integer payStatus;

    private Integer orderType;

    private String orderTypeName;

    private Integer orderStatus;

    private String orderStatusName;

    private Integer cancelType;

    private String cancelTypeName;

    private String cancelReason;

    private Date cancelTime;

    private Integer orderReturnStatus;

    private String orderReturnStatusName;

    private String ramake;

    private Date creatTime;

    private Integer deleteFlag;

    private Date finshTime;

    private Date deliveryTime;

    private Date receiveTime;

    private Integer onCredit;

    private Double chargeAmount;

    private Double refundAmount;

    private Integer saleType;

    private String saleName;

    private Integer inAmount;

    private Integer removeSmallAmount;

    private Double serviceFee;

    private Double rewardAmount;

    private Integer promotionApmount;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getReceivablesAmount() {
        return receivablesAmount;
    }

    public void setReceivablesAmount(Double receivablesAmount) {
        this.receivablesAmount = receivablesAmount;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getOrderTypeName() {
        return orderTypeName;
    }

    public void setOrderTypeName(String orderTypeName) {
        this.orderTypeName = orderTypeName == null ? null : orderTypeName.trim();
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusName() {
        return orderStatusName;
    }

    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName == null ? null : orderStatusName.trim();
    }

    public Integer getCancelType() {
        return cancelType;
    }

    public void setCancelType(Integer cancelType) {
        this.cancelType = cancelType;
    }

    public String getCancelTypeName() {
        return cancelTypeName;
    }

    public void setCancelTypeName(String cancelTypeName) {
        this.cancelTypeName = cancelTypeName == null ? null : cancelTypeName.trim();
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason == null ? null : cancelReason.trim();
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public Integer getOrderReturnStatus() {
        return orderReturnStatus;
    }

    public void setOrderReturnStatus(Integer orderReturnStatus) {
        this.orderReturnStatus = orderReturnStatus;
    }

    public String getOrderReturnStatusName() {
        return orderReturnStatusName;
    }

    public void setOrderReturnStatusName(String orderReturnStatusName) {
        this.orderReturnStatusName = orderReturnStatusName == null ? null : orderReturnStatusName.trim();
    }

    public String getRamake() {
        return ramake;
    }

    public void setRamake(String ramake) {
        this.ramake = ramake == null ? null : ramake.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getFinshTime() {
        return finshTime;
    }

    public void setFinshTime(Date finshTime) {
        this.finshTime = finshTime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Integer getOnCredit() {
        return onCredit;
    }

    public void setOnCredit(Integer onCredit) {
        this.onCredit = onCredit;
    }

    public Double getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(Double chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Integer getSaleType() {
        return saleType;
    }

    public void setSaleType(Integer saleType) {
        this.saleType = saleType;
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName == null ? null : saleName.trim();
    }

    public Integer getInAmount() {
        return inAmount;
    }

    public void setInAmount(Integer inAmount) {
        this.inAmount = inAmount;
    }

    public Integer getRemoveSmallAmount() {
        return removeSmallAmount;
    }

    public void setRemoveSmallAmount(Integer removeSmallAmount) {
        this.removeSmallAmount = removeSmallAmount;
    }

    public Double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(Double serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Double getRewardAmount() {
        return rewardAmount;
    }

    public void setRewardAmount(Double rewardAmount) {
        this.rewardAmount = rewardAmount;
    }

    public Integer getPromotionApmount() {
        return promotionApmount;
    }

    public void setPromotionApmount(Integer promotionApmount) {
        this.promotionApmount = promotionApmount;
    }
}