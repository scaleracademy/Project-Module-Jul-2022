package com.scaler.inheritence;

import java.util.ArrayList;
import java.util.List;

public class TypeErasure {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("asdasd");

        ArrayList<Object> list2 = list;

        list2.add(123);
    }
}
