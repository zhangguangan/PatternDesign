package com.patternDesign.mediator;

public interface Mediator {

    void sendMsg(String message, Colleague colleague);
}
