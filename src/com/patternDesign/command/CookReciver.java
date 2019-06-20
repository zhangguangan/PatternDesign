package com.patternDesign.command;

public class CookReciver implements Reciver {
    @Override
    public void cook() {
        System.out.println("厨师做饭");
    }

    @Override
    public void unCook() {
        System.out.println("厨师取消做饭");
    }
}
