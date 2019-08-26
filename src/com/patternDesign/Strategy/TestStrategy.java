package com.patternDesign.Strategy;

public class TestStrategy {
    public static void test() {
        Person person = new Person("小明", "20");

        SmallCarStrategy smallCarStrategy = new SmallCarStrategy("小汽车", "红色");
        BigCarStrategy bigCarStrategy = new BigCarStrategy("大汽车", "白色");

        person.drive(smallCarStrategy);
        person.drive(bigCarStrategy);

    }
}
