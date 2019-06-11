package com.patternDesign.bridge;

public class OracleDbDriver implements DBDriver {
    @Override
    public void connection() {
        System.out.println("connection to mysql");
    }
}
