package com.patternDesign.adapter;

public class Adapter4Class extends Usb implements ITypeC {
    @Override
    public void typeCInterface() {
        System.out.println("adapter 4 typec");
    }
}
