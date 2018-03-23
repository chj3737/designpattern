package com.chj.designpattern.enumpattern;

public enum EnumStrategy {

    Strategy1("s1") {
        public void operate() {
            // do s1 specific operation
            System.out.println(this.name + "'s strategy");
        }

    },

    Strategy2("s2") {
        public void  operate() {
            // do s2 specific operation
            System.out.println(this.name + "'s strategy");
        }

    };

    String name;
    EnumStrategy(String name) {
        this.name = name;
    }


    abstract public void  operate();


    public static void main(String[] args) {
        // valueOf look up enum by name
        String strategy =  "Strategy1";
        EnumStrategy.valueOf(strategy).operate();
        strategy =  "Strategy2";
        EnumStrategy.valueOf(strategy).operate();
        // also learn how enum is used
    }
}
