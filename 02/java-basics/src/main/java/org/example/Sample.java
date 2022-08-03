package org.example;

public class Sample {

    public static void main(String[] args) {
        System.out.println("Hello Sample!");

        Person p = new Person("John", 32);

    }

    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
