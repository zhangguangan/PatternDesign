package com.patternDesign.Strategy;

import java.awt.*;

public abstract class Strategy {
    private String name;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Strategy(String name, String color) {
        this.name = name;
        this.color = color;
    }
        abstract void run();
}
