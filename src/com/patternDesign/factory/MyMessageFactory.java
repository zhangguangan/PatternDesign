package com.patternDesign.factory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 工厂方法类
 */
public class MyMessageFactory implements IMyMessageFactory {
    private final static Map<Integer, IMyMessage> messageMapping = new HashMap<>();
    private final static String BASE_PACKAGE = "com.patternDesign.factory.";
    private final static MyMessageFactory factory = new MyMessageFactory();

    private MyMessageFactory() {
        super();
    }

    // 1、初始化工厂
    static {
        try {
            //  1、根据枚举的类型获取生产者对象列表
            Class<?> clazz = MyMessageEnum.class;
            Object[] enums = clazz.getEnumConstants();
            Method getProducerTypeMtd = clazz.getMethod("getProducerType");
            Method getClassTypeMtd = clazz.getMethod("getClassType");

            // 2、给生产者类型列表添加映射
            for (Object obj : enums) {
                Integer classType = (Integer) getProducerTypeMtd.invoke(obj);
                String produceClassType = (String) getClassTypeMtd.invoke(obj);
                IMyMessage myMessage = (IMyMessage) Class.forName(BASE_PACKAGE + produceClassType).newInstance();
                messageMapping.put(classType, myMessage);
            }
        } catch (Exception e) {
            System.out.println("异常，异常信息" + e.getMessage());
        }
    }

    /**
     * 获取生产者对象
     * @param messageEnum
     * @return
     */
    @Override
    public IMyMessage createMessage(MyMessageEnum messageEnum) {
        // 根据生产者类型从生产者映射中获取生产者
        IMyMessage message = messageMapping.get(messageEnum.getProducerType());
        return message;
    }

    public static MyMessageFactory getInstance() {
        return factory;
    }
}
