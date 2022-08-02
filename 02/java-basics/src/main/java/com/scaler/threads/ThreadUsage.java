package com.scaler.threads;

public class ThreadUsage {

    public static void main(String[] args) {

        var start = System.currentTimeMillis();
        System.out.println("wait started");

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                int runCounter = 0;
                while (System.currentTimeMillis() - start < 10000) {
                    // do nothing
                    runCounter++;
                }
                System.out.println("wait " + finalI + " finished, ran " + runCounter + " times");

            }).start();
        }

    }
}
