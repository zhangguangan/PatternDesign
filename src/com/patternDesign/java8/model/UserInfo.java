package com.patternDesign.java8.model;

import java.math.BigDecimal;

public class UserInfo {
    private String userName;
    private Integer userType;
    private BigDecimal rate;

    public UserInfo(String userName) {
        this.userName = userName;
    }
    public UserInfo() {
    }
    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
    public void calculateAmount(BigDecimal totalAmount) {
        System.out.println(rate.multiply(totalAmount));
    }
}
