package com.patternDesign.template;

public class TestTemplate {
     public static void test() {
         BeverageTemplate coffee = new CoffeeBeverge();
         BeverageTemplate tea = new TeaBeverage();
         coffee.prepareBeverge();
         tea.prepareBeverge();
     }
}
