package org.example;

public class Fruit {
    String color;
    String taste;

    public Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }

    public boolean isTasty() {
        return taste.equals("sweet");
    }

    static public Fruit copy(Fruit oldFruit) {
        return new Fruit(oldFruit.color, oldFruit.taste);
    }
}
