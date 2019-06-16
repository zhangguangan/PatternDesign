package com.patternDesign.flowWeight;

import java.util.Hashtable;

public class IgoChessmanFactory {
    private static IgoChessmanFactory instance = new IgoChessmanFactory();
    private static Hashtable<String, IgoChessman> ht; //使用Hashtable来存储享元对象，充当享元池

    private IgoChessmanFactory() {
        ht = new Hashtable();
        IgoChessman blackChessman = new BlackIgoChessman();
        IgoChessman whiteChessman = new WhiteIgoChessman();

        ht.put("black", blackChessman);
        ht.put("white", whiteChessman);
    }

    public static IgoChessmanFactory getInstance(){
        return instance;
    }
    public IgoChessman getIgoChessman(String color) {
        return ht.get(color);
    }
}
