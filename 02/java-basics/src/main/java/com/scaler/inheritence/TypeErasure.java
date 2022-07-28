package com.scaler.inheritence;

import java.util.ArrayList;
import java.util.List;

public class TypeErasure {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("asdasd");

//        ArrayList<Object> list2 = list;
//
//        list2.add(123);

        Object x = "asd";
        System.out.println(x);
        x = 10;
        System.out.println(x);


        ArrayList<Object> objList = new ArrayList<>();
        objList.add("Asd");
        objList.add(12);
        objList.add(new Apple());

        objList.forEach(System.out::println);

        List<Fruit> fruitBasket = new ArrayList<>();
        fruitBasket.add(new Apple());
        fruitBasket.add(new Mango());


        List<Apple> appleDozen = new ArrayList<Apple>(12);
        fruitBasket.addAll(appleDozen);
    }
}
