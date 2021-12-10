package com.sample;

import java.io.FilterOutputStream;
import java.util.Arrays;
import java.util.Random;

public class App {

    public static void main(String[] args) {
        int amount = 100000000;     // amount of integer in array
        int[] arr = generateIntArray(amount);

        int lessThan = 30000000;
        int greaterThan = 70000000;

        long startTime, endTime;

//        startTime = System.nanoTime();
//        Arrays.sort(arr);
//        endTime = System.nanoTime();
//        System.out.printf("%fms of sort operation %n", (endTime - startTime) / 1000000.0);

        // Count with single thread
        startTime = System.nanoTime();
        int[] result = CountThread.countElements(arr, lessThan, greaterThan);
        endTime = System.nanoTime();

//        System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining("  ")));

        System.out.println("Count with single thread");
        System.out.printf("%d numbers of less than %d\n", result[0], lessThan);
        System.out.printf("%d numbers of less than %d\n", result[1], greaterThan);
        System.out.printf("%fms %n", (endTime - startTime) / 1000000.0);

        // Count with MultiThread
        int threadCount = 4;
        int taskSize = (int) Math.ceil(amount * 1.0 / threadCount);
        CountThreadStore store = new CountThreadStore();
        store.lessThan = lessThan;
        store.greaterThan = greaterThan;

        for(int i = 0; i < threadCount - 1; i++) {
            Thread thread = new CountThread(arr, i * taskSize, taskSize, lessThan, greaterThan, store);
            thread.start();
        }
        Thread thread = new CountThread(arr, (threadCount - 1) * taskSize, amount - ((threadCount - 1) * taskSize), lessThan, greaterThan, store);
        thread.start();

    }

    /**
     * Genertate random integer array
     *
     * @param amount
     * @return
     */
    private static int[] generateIntArray(int amount) {
        Random rd = new Random();
        int[] arr = new int[amount];
        for (int i = 0; i < amount; i++) {
            arr[i] = rd.nextInt(amount * 2);
        }

        return arr;
    }
}
