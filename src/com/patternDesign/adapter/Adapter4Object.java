package com.patternDesign.adapter;

public class Adapter4Object extends Usb{
    ITypeC  typeC;


    public ITypeC getTypeC() {
        return typeC;
    }

    public void setTypeC(ITypeC typeC) {
        this.typeC = typeC;
    }
}
