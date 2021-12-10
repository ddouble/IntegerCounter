package com.sample;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
//        int[] arr = new int[]{6, 1, 10, 8};
        int[] arr = generateIntArray(100000000);

        int lessThan = 30000000;
        int greaterThan = 70000000;

        long startTime = System.nanoTime();
        int[] result = CountThread.countElements(arr, lessThan, greaterThan);
        long endTime = System.nanoTime();

//        System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining("  ")));
        System.out.printf("%d numbers of less than %d\n", result[0], lessThan);
        System.out.printf("%d numbers of less than %d\n", result[1], greaterThan);
        System.out.printf("%fms %n", (endTime - startTime) / 1000000.0);

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
