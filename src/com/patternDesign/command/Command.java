package com.patternDesign.command;

public abstract class Command {
    Reciver reciver;
    public abstract void order();
    public abstract void unOrder();

    public Reciver getReciver() {
        return reciver;
    }

    public void setReciver(Reciver reciver) {
        this.reciver = reciver;
    }
}
