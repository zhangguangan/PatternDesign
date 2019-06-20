package com.patternDesign.iterator;

public class IteratorTest {

    public static void test() {
        ConcreteAggregate<String> concreteAggregate = new ConcreteAggregate<>();

        concreteAggregate.add("a");
        concreteAggregate.add("b");
        concreteAggregate.add("c");
        concreteAggregate.add("d");
        concreteAggregate.add("e");
        concreteAggregate.add("f");

        System.out.println("容器大小：" + concreteAggregate.getSize());
        Iterator<String> iterator = concreteAggregate.toIterrator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
