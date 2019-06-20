package com.patternDesign.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SingerProxyHandler implements InvocationHandler {
    ISinger singer = null;

    public void setSinger(ISinger singer) {
        this.singer = singer;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("向观众问好");
        Object result = method.invoke(singer, args);
        System.out.println("向观众致意");
        return result;
    }

    public static void test() {
        Singer singer = new Singer();
        SingerProxyHandler singerProxyHandler = new SingerProxyHandler();
        singerProxyHandler.setSinger(singer);

        ISinger iSinger = (ISinger) Proxy.newProxyInstance(singer.getClass().getClassLoader(), singer.getClass().getInterfaces(), singerProxyHandler);
        iSinger.sing();
    }
}
