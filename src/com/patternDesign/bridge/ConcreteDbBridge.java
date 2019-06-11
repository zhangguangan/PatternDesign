package com.patternDesign.bridge;

public class ConcreteDbBridge extends AbstractDbBridge {
    @Override
    public void connection() {
        getDbDriver().connection();
    }
}
