package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Fruit apple = new Fruit("red", "sweet");
        Fruit lime = new Fruit("yellow", "sour");

        System.out.println("Is apple tasty? " + apple.isTasty());
        System.out.println("Is lime tasty? " + lime.isTasty());

        Fruit appleCopy = new Fruit(apple.color, apple.taste);
    }
}