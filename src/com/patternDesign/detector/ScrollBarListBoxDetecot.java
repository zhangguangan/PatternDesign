package com.patternDesign.detector;

public class ScrollBarListBoxDetecot extends ComponentDetector {
    public ScrollBarListBoxDetecot(Component component) {
        super(component);
    }
    public void setScrollBar4ListBox() {
        super.display();
        System.out.println("添加滚动条");
    }
}
