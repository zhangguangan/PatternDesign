package com.patternDesign.observe;

import java.util.ArrayList;
import java.util.List;

public class TeacherSubject implements Subject {
    private List<Observer> observerList = new ArrayList<>();
    private String homeWork;

    public String getHomeWork() {
        return homeWork;
    }

    public void setHomeWork(String homeWork) {
        this.homeWork = homeWork;
    }

    @Override
    public void addOberver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.notifyMsg("今天的作业是：" + this.homeWork);
        }
    }
}
