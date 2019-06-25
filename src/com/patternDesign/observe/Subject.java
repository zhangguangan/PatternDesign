package com.patternDesign.observe;

public interface Subject {
    void addOberver(Observer observer);

    void deleteObserver(Observer observer);

    void notifyObservers();
}
