package com.patternDesign.combination;

public abstract class Node {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node(String name) {
        this.name = name;
    }

    public void addNode(Node node) throws Exception {
        throw new RuntimeException("invalidate exception");
    }

    abstract void display();
}
