package com.chj.designpattern;

import com.chj.designpattern.enumpattern.EnumStrategy;

interface IStrategy {
    void operate();
}

class Context{
    IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void useStrategy() {
        strategy.operate();
    }
}

class Strategy1 implements IStrategy {
    @Override
    public void operate() {
        System.out.println("strategy 1");
    }
}

class Strategy2 implements IStrategy {
    @Override
    public void operate() {
        System.out.println("strategy 2");
    }
}


/**
 *
 * see also {@link EnumStrategy}
 */
public class StrategyPattern {

    public static void main(String[] args) {
        Strategy1 s1 = new Strategy1();
        Strategy2 s2 = new Strategy2();
        Context c = new Context(s1);
        c.useStrategy();
        c = new Context(s2);
        c.useStrategy();
    }
}
