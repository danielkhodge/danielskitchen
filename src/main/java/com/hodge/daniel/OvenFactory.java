package com.hodge.daniel;

public class OvenFactory {
    private Oven instance;

    public Oven getInstance() {
        if (instance == null) {
            instance = new Oven();
        }
        return instance;
    }
}
