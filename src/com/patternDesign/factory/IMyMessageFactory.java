package com.patternDesign.factory;

/**
 * 工厂接口类
 */
public interface IMyMessageFactory {

    IMyMessage createMessage(MyMessageEnum messageEnum);
}
