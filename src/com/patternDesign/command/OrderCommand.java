package com.patternDesign.command;

public class OrderCommand extends Command {
    public OrderCommand() {
        this.reciver = new CookReciver();
    }

    @Override
    public void order() {
        System.out.println("服务员传递消息做饭");
        this.reciver.cook();
    }

    @Override
    public void unOrder() {
        System.out.println("服务员传递消息取消做饭");
        this.reciver.unCook();
    }
}
