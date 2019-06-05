package com.patternDesign.factory;

import java.util.Map;

/**
 * 生产者类型2
 */
public class MyMessageEmail extends AbstractMyMessage {
    @Override
    public void sendMessage() {
        Map<String, Object> parameters = getParameters();
        if (parameters != null) {
            System.out.println("发送邮件：" + parameters.get("email"));
        } else {
            System.out.println("发送邮件");
        }

    }
}
