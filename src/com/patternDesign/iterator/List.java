package com.patternDesign.iterator;

public interface List<T> {
    Iterator<T> toIterrator();
    void add(T data);
    T get(int index);
    Integer getSize();
}
