package com.patternDesign.chain;

public class JingliLeader extends Leader {
    @Override
    public void handleRequest(Integer days) {
        if (days > 10) {
            nextLeader.handleRequest(days);
        } else {
            System.out.println("主任处理，请假天数：" + days);
        }
    }
}
