package com.scaler.inheritence;

public class Mango extends Fruit {
    boolean ripe;   // 1 byte

    public boolean isLarge() {
        return getSize() > 5;
    }
}
