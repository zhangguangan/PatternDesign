package com.patternDesign.combination;

/**
 * 文件实现类
 */
public class FileNode extends Node {
    public FileNode(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println(name);
    }
}
