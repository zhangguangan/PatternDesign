package com.patternDesign.singleton;

public class Singleton {
    private static Singleton single = null;
    private String msg;
    private Singleton() {
    }
    public static Singleton getSingle() {
        return single;
    }

    public static void setSingle(Singleton single) {
        Singleton.single = single;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void getDesc() {
        System.out.println("单例:" + getMsg());
    }
    public static Singleton getInstance() {
        if (single == null) {
            synchronized (Singleton.class) {
                if (single == null) {
                    single = new Singleton();
                }
            }
        }
        return single;
    }

    /**
     * 带有初始化参数的单例模式
     * @param msg
     * @return
     */
    public static Singleton getInstance(String msg) {
        getInstance();
        single.setMsg(msg);
        return single;
    }
}
