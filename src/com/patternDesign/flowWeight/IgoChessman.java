package com.patternDesign.flowWeight;

/**
 * 棋子抽象类：抽象享元类
 */
public abstract class IgoChessman {
    public abstract String getColor();

    public void dispaly(Coordinates coordinates) {
        System.out.println("棋子颜色：" + getColor() + ", 所在位置 x:" + coordinates.getX() + " y:" + coordinates.getY());
    }

}
