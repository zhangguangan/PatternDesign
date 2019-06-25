package com.patternDesign.template;

/**
 * 抽象饮品类
 * 定义饮品制作方法和过程
 */
public abstract class BeverageTemplate {
    public void prepareBeverge() {
        boilWater();
        brew();
        pourInCup();
        if (isRequireConditions()) {
            addConditions();
        }
    }

    private void boilWater() {
        System.out.println("把水烧开");
    }

    public abstract void brew();

    private void pourInCup() {
        System.out.println("将饮料倒入杯中");
    }

    public abstract void addConditions();


    /**
     * 钩子方法 使方法更灵活
     */
    public abstract boolean isRequireConditions();
}
