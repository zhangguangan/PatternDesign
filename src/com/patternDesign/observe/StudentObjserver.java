package com.patternDesign.observe;

public class StudentObjserver implements Observer {
    private String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public void notifyMsg(String info) {
        System.out.println(studentName + " 收到消息: " + info);
    }
}
