package java8.function.test;

import java8.model.UserInfo;

import java.math.BigDecimal;
import java.util.function.BiConsumer;

public enum MemberCalEnum {
    DEFULT(0, UserInfo::calculateAmount),
    MEMBER(1, UserInfo::calculateAmount),
    VIP(2, UserInfo::calculateAmount),
    ;
    private Integer userType;
    private BiConsumer<UserInfo, BigDecimal> function;

    public Integer getUserType() {
        return userType;
    }

    public BiConsumer<UserInfo, BigDecimal> getFunction() {
        return function;
    }

    public void setFunction(BiConsumer<UserInfo, BigDecimal> function) {
        this.function = function;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    MemberCalEnum(Integer userType, BiConsumer<UserInfo, BigDecimal> function) {
        this.userType = userType;
        this.function = function;
    }

    public static MemberCalEnum getType(Integer userType) {
        for (MemberCalEnum memberCalEnum : values()) {
            if (memberCalEnum.getUserType().equals(userType)) {
                return memberCalEnum;
            }
        }
        return DEFULT;
    }
}
