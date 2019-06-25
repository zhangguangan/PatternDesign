package com.patternDesign.visitor;

public class TestVisitor {

    public static void test() {
        StaffObject e=new StaffObject();
        e.addEmployee(new Staff("张三", 3000f, 2, 1));
        e.addEmployee(new Staff("李四", 5000f, 4, 2));
        e.addEmployee(new Staff("王五", 8000f, 6, 3));
        e.addEmployee(new Staff("沈七", 10000f, 9, 4));
        e.Accept(new ConcreteVisitor());
    }
}
