package com.patternDesign.Strategy;

public class SmallCarStrategy extends Strategy {
    public SmallCarStrategy(String name, String color) {
        super(name, color);

    }

    @Override
    void run() {
        System.out.println(getName() + " 颜色：" + getColor() + " 在行驶");
    }
}
