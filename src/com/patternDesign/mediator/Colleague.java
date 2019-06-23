package com.patternDesign.mediator;

public abstract class Colleague {
    String name;
    Mediator mediator;

    public Colleague(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public abstract void sendMsg(String msg);
    public abstract void notify(String msg);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
