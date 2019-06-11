package com.patternDesign.bridge;

public class MysqlDBDriver implements DBDriver {
    @Override
    public void connection() {
        System.out.println("connection to mysql");
    }
}
