package com.patternDesign.mediator;

public class CollegueB extends Colleague {
    public CollegueB(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    public void sendMsg(String msg) {
        mediator.sendMsg(msg, this);
    }

    @Override
    public void notify(String msg) {
        System.out.println(name + "得到消息：" + msg);
    }

}
