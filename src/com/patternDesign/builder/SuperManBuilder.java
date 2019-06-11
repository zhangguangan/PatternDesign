package com.patternDesign.builder;

public class SuperManBuilder implements IHumanBuilder {
    private Human human;

    public SuperManBuilder() {
        this.human = new Human();
    }
    @Override
    public void setHeader() {
        human.setHeader("header");
    }

    @Override
    public void setBody() {
        human.setBody("body");
    }

    @Override
    public void setFoot() {
        human.setFoot("foot");
    }

    @Override
    public void setHand() {
        human.setHand("hand");
    }

    @Override
    public Human createHuman() {
        return human;
    }
}
