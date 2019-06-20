package com.patternDesign.command;

public class Customer {
    public static void test() {
        Command cmd = new OrderCommand();
        cmd.order();
        cmd.unOrder();
    }
}
