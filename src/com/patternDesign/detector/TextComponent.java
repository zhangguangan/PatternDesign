package com.patternDesign.detector;

public class TextComponent implements Component {
    @Override
    public void display() {
        System.out.println("文本框");
    }
}
