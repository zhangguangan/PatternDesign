package com.patternDesign.java8.function.test;

import com.patternDesign.java8.model.UserInfo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class FunctionTest {
    public static UserInfo getUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserType(MemberCalEnum.MEMBER.getUserType());
        userInfo.setUserName("张三");
        userInfo.setRate(new BigDecimal("0.30"));
        return userInfo;
    }
    public static BigDecimal getProductTotalAmount() {
        return new BigDecimal("1000.00");
    }
    public static void biconsumerTest() {
        BiConsumer<Integer, Integer> consumer = (a, b) -> { System.out.println(a + b); };
        consumer.accept(10, 20);
    }
    public static void main(String[] args) {
        // 1、方式1
        UserInfo userInfo = getUserInfo();
        MemberCalEnum.MEMBER.getFunction().accept(userInfo, getProductTotalAmount());

        // 2、方式二
        BiConsumer<UserInfo, BigDecimal> c = (user, totalAmount) -> {
            System.out.println(user.getRate().multiply(totalAmount));
        };
        c.accept(userInfo, getProductTotalAmount());

        // 3、方式1
        BiConsumer<UserInfo, BigDecimal> d = UserInfo::calculateAmount;
        d.accept(userInfo, getProductTotalAmount());


        biconsumerTest();
    }
}
