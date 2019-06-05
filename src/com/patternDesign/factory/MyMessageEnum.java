package com.patternDesign.factory;


/**
 * 生产者类型枚举
 */
public enum  MyMessageEnum {
    MESSAGE_EMAIL(1, "MyMessageEmail"),
    MESSAGE_SMS(2, "MyMessageSms");

    private Integer producerType;
    private String classType;

    MyMessageEnum(Integer producerType, String classType) {
        this.producerType = producerType;
        this.classType = classType;
    }

    public Integer getProducerType() {
        return producerType;
    }

    public String getClassType() {
        return classType;
    }
}
