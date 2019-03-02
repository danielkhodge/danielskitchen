package com.hodge.daniel;

public class OvenFactory {
    private static Oven instance;

    public static Oven getOven() {
        if (instance == null) {
            instance = new Oven();
        }
        return instance;
    }
}
