package com.scaler.inheritence;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Mango mango = new Mango();              // byte
        System.out.println(mango.isLarge());

        List<String> list = new ArrayList<>();

        var list2 = new ArrayList<String>();

        // type-erasure ?

        ArrayList<Fruit> fruitBasket = new ArrayList<>();
        List<Fruit> fruitBasket2 = new ArrayList<>();

        fruitBasket.add(new Apple());
        fruitBasket.add(new Mango());

    }
}
