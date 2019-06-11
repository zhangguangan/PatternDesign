package com.patternDesign.bridge;

public abstract class AbstractDbBridge {
    private DBDriver dbDriver;
    public void connection() {
        dbDriver.connection();
    }

    public DBDriver getDbDriver() {
        return dbDriver;
    }

    public void setDbDriver(DBDriver dbDriver) {
        this.dbDriver = dbDriver;
    }
}
