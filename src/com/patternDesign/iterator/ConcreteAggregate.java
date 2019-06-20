package com.patternDesign.iterator;



public class ConcreteAggregate<T> implements List<T> {
    private Object[] list;
    private Integer size = 0;
    private Integer index = 0;

    public ConcreteAggregate() {
        index = 0;
        size = 0;
        Object[] objects = new Object[100];
        list = objects;
    }

    @Override
    public Iterator toIterrator() {
        Iterator iterator = new ConcreteIterator(this);
        return iterator;
    }

    @Override
    public void add(T data) {
        list[index++] = data;
        size++;
    }

    @Override
    public T get(int index) {
        if (index > size) {
            throw new RuntimeException("out of bound exception");
        }

        return (T)list[index];
    }

    @Override
    public Integer getSize() {
        return size;
    }
}
