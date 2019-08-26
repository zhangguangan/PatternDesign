package com.patternDesign.visitor;

/**
 * 定义一个接受访问操作类，访问者(Visitor)操作函数的参数。
 */
public abstract class Element {
    public abstract void Acceppt(Visitor visitor);
}
