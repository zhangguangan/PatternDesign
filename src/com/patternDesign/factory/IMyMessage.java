package com.patternDesign.factory;

import java.util.Map;

/**
 * 生产者接口
 */
public interface IMyMessage {

    Map<String, Object> getParameters();

    void setParameters(Map<String, Object> parameters);

    void sendMessage();
}
