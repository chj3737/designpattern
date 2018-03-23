package com.chj.designpattern.enumpattern;

public enum EnumSingleton {
    INSTANCE;

    void doSomething() {
        System.out.println("do something");
    }

    public static void main(String[] args) {
        EnumSingleton.INSTANCE.doSomething();
    }
}
