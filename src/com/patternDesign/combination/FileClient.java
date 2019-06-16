package com.patternDesign.combination;

import java.io.File;

public class FileClient {
    public static void createTree(Node node) {
        try {
            File file = new File(node.getName());
            File[] files = file.listFiles();
            for (File fi : files) {
                if (fi.isFile()) {
                    FileNode fileNode = new FileNode(fi.getAbsolutePath());
                    node.addNode(fileNode);
                }
                if (fi.isDirectory()) {
                    FolderNode folderNode = new FolderNode(fi.getAbsolutePath());
                    node.addNode(folderNode);
                    createTree(folderNode);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
