package com.patternDesign.combination;

import java.util.ArrayList;
import java.util.List;

public class FolderNode extends Node {
    //内部节点列表（包括文件和下级目录）
    List<Node> nodeList = new ArrayList<Node>();
    public FolderNode(String name) {
        super(name);
    }

    @Override
    public void addNode(Node node) throws Exception {
        this.nodeList.add(node);
    }

    @Override
    public void display() {
        System.out.println(name);
        for (Node node : nodeList) {
            node.display();
        }
    }
}
