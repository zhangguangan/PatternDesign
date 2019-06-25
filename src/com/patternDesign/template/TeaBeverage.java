package com.patternDesign.template;

public class TeaBeverage extends BeverageTemplate {
    @Override
    public void brew() {
        System.out.println("用八十度水冲泡茶叶");
    }

    @Override
    public void addConditions() {
        System.out.println("加点柠檬");
    }

    @Override
    public boolean isRequireConditions() {
        return false;
    }
}
