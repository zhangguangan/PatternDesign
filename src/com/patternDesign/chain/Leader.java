package com.patternDesign.chain;

public abstract class Leader {
    Leader nextLeader = null;
    abstract void handleRequest(Integer days);

    public Leader getNextLeader() {
        return nextLeader;
    }

    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }
}
