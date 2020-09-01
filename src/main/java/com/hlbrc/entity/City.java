package com.hlbrc.entity;

public class City {
    private Integer citId;

    private String citName;

    private Integer proId;

    public Integer getCitId() {
        return citId;
    }

    public void setCitId(Integer citId) {
        this.citId = citId;
    }

    public String getCitName() {
        return citName;
    }

    public void setCitName(String citName) {
        this.citName = citName == null ? null : citName.trim();
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }
}