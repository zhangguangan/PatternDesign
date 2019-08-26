package com.patternDesign.observe;

public class TestObserver {
    public static void test() {
        StudentObjserver zhangsan = new StudentObjserver();
        StudentObjserver lisi = new StudentObjserver();
        zhangsan.setStudentName("张三");
        lisi.setStudentName("李四");

        TeacherSubject subject = new TeacherSubject();
        subject.addOberver(zhangsan);
        subject.addOberver(lisi);

        subject.setHomeWork("100个英语单词");
        subject.notifyObservers();
    }
}
