package com.patternDesign.visitor;

import java.util.HashMap;

/**
 * 结构对象:这是使用访问者模式必备的角色。
 * 它具备以下特性：
 * 能枚举它的元素；
 * 可以提供一个高层接口以允许访问者访问它的元素；
 * 如有需要，可以设计成一个复合对象或者一个聚集（如一个列表或无序集合）。
 */
public class StaffObject {
    private HashMap<String, Staff> employees;

    public StaffObject() {
        employees = new HashMap<String, Staff>();
    }

    public void addEmployee(Staff e) {
        if (!employees.containsKey(e.getName())) {
            employees.put(e.getName(), e);
        }
    }

    public void removeEmployee(Staff e) {
        if (employees.containsKey(e.getName())) {
            employees.remove(e);
        }
    }

    public Staff getEmployee(String name) {
        return employees.get(name);
    }

    public void Accept(Visitor v) {
        for (Staff e : employees.values()) {
            e.Acceppt(v);
        }
    }
}