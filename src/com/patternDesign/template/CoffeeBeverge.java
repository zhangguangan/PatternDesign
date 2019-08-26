package com.patternDesign.template;

public class CoffeeBeverge extends BeverageTemplate {
    @Override
    public void brew() {
        System.out.println("用沸水冲泡咖啡");
    }

    @Override
    public void addConditions() {
        System.out.println("加糖和牛奶");
    }

    @Override
    public boolean isRequireConditions() {
        return true;
    }
}
