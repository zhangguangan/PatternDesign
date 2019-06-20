package com.patternDesign.iterator;

public class ConcreteIterator<T> implements Iterator {
    private List<T> list;
    private Integer index = 0;

    public ConcreteIterator(List list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (index >= list.getSize()) {
            return false;
        }
        return true;
    }

    @Override
    public T next() {
        T obj = list.get(index);
        index++;
        return obj;
    }
}
