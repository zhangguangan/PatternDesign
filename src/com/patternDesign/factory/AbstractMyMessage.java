package com.patternDesign.factory;

import java.util.Map;

/**
 * 生产者抽象
 */
public abstract class AbstractMyMessage implements IMyMessage {
    private Map<String, Object> parameters;

    @Override
    public Map<String, Object> getParameters() {
        return parameters;
    }

    @Override
    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }
}
