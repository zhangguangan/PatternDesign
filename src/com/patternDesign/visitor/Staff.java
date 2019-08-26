package com.patternDesign.visitor;


/**
 * 具体元素，实现了抽象元素(Element)所定义的接受操作接口。
 */
public class Staff extends Element {
    private String name;
    private float salary;
    private int workAges;
    private int degree;

    public Staff(String name, float salary, int workAges, int degree) {
        super();
        this.name = name;
        this.salary = salary;
        this.workAges = workAges;
        this.degree = degree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getWorkAges() {
        return workAges;
    }

    public void setWorkAges(int workAges) {
        this.workAges = workAges;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    @Override
    public void Acceppt(Visitor visitor) {
        visitor.visit(this);
    }
}
