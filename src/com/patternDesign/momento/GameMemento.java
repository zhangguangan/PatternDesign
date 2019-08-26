package com.patternDesign.momento;


/**
 * 备忘录类
 */
public class GameMemento {
    private Integer playSteps;



    public void saveCommento(Game game) {
        this.playSteps = game.getPlaySteps();
    }

    public Game retrieveMemento() {
        Game game = new Game();
        game.setPlaySteps(this.playSteps);
        return game;
    }
}
