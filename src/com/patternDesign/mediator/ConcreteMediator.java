package com.patternDesign.mediator;

public class ConcreteMediator implements Mediator {
    CollegueA collegueA;
    CollegueB collegueB;

    public void setCollegueA(CollegueA collegueA) {
        this.collegueA = collegueA;
    }

    public void setCollegueB(CollegueB collegueB) {
        this.collegueB = collegueB;
    }

    @Override
    public void sendMsg(String message, Colleague colleague) {
        if (colleague == collegueA) {
            collegueB.notify(message);
        } else {
            collegueA.notify(message);
        }
    }
}
