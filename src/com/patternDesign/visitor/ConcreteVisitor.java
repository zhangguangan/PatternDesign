package com.patternDesign.visitor;

public class ConcreteVisitor implements Visitor {
    @Override
    public void visit(Element element) {
        Staff e=(Staff) element;
        //比如：加薪的计算方式：职位*加薪系数+工龄*对应系统之和 除以10 再乘以现在工资
        // 在此处可以更改需要修改的方法
        System.out.println(e.getName()+"要加的薪水是："+(e.getDegree()*0.8+e.getWorkAges()*0.5)/10*e.getSalary());
    }
}
