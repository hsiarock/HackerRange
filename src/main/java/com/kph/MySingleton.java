package com.kph;

public enum MySingleton {
    INSTANCE;

    public void doSomething() {
        something = "abc";
        System.out.println("do something - singleton");

    }

    public synchronized String getSomething() { return something; }

    private String something;
}