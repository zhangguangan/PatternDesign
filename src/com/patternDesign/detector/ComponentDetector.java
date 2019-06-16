package com.patternDesign.detector;

public abstract class ComponentDetector implements Component {
    private Component component;

    public ComponentDetector(Component component) {
        this.component = component;
    }

    public void display() {
        component.display();
    }
}
