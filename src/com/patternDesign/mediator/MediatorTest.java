package com.patternDesign.mediator;

public class MediatorTest {

    public static void test() {
        ConcreteMediator mediator = new ConcreteMediator();
        CollegueA collegueA = new CollegueA("同事A", mediator);
        CollegueB collegueB = new CollegueB("同事B", mediator);

        mediator.setCollegueA(collegueA);
        mediator.setCollegueB(collegueB);

        collegueA.sendMsg("hello 同事B");
    }
}
