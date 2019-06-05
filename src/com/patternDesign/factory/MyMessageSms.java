package com.patternDesign.factory;

import java.util.Map;

/**
 * 生产者类型1
 */
public class MyMessageSms extends AbstractMyMessage {
    @Override
    public void sendMessage() {
        Map<String, Object> parameters = getParameters();
        if (parameters != null) {
            System.out.println("发送短信：" + parameters.get("sms"));
        } else {
            System.out.println("发送短信");
        }
    }
}
