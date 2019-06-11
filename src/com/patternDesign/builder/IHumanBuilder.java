package com.patternDesign.builder;

public interface IHumanBuilder {
    void setHeader();
    void setBody();
    void setFoot();
    void setHand();
    Human createHuman();
}
