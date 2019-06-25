package com.patternDesign.momento;

public class TestMomento {

    public static void test() {
        Game game = new Game();
        game.setPlaySteps(1);
        GameMemento gameMemento = new GameMemento();
        gameMemento.saveCommento(game);

        Caretaker caretaker = new Caretaker();
        caretaker.setGameMemento(gameMemento);

        game.setPlaySteps(2);

        game = caretaker.getGameMemento().retrieveMemento();

        System.out.println("恢复备忘录中的游戏步数：" + game.getPlaySteps());
    }
}
