package com.patternDesign.proxy;

public class Singer implements ISinger {
    @Override
    public void sing() {
        System.out.println("歌唱");
    }

    @Override
    public void speak() {
        System.out.println("speak");
    }
}
