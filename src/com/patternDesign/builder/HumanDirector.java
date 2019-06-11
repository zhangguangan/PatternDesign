package com.patternDesign.builder;

public class HumanDirector {
    public static Human createHuman(IHumanBuilder humanBuilder) {
        humanBuilder.setHeader();
        humanBuilder.setBody();
        humanBuilder.setFoot();
        humanBuilder.setHand();
        return humanBuilder.createHuman();
    }
}
