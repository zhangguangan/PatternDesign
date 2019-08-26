package com.patternDesign.momento;

/**
 * 备忘录管理类
 */
public class Caretaker {
    private  GameMemento gameMemento;

    public GameMemento getGameMemento() {
        return gameMemento;
    }

    public void setGameMemento(GameMemento gameMemento) {
        this.gameMemento = gameMemento;
    }
}
